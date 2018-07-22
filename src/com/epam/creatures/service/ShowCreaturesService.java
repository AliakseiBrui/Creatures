package com.epam.creatures.service;

import com.epam.creatures.action.CreatureListSorter;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.CreatureColumn;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.impl.CreaturesDao;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.MarkDao;
import com.epam.creatures.entity.ClientRole;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.Mark;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Base64;
import java.util.List;
import java.util.Map;

public class ShowCreaturesService implements ProjectService {
    private static final Logger LOGGER = LogManager.getLogger(ShowCreaturesService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        CreaturesDao creaturesDAO = new CreaturesDao();
        RouterFactory routerFactory = new RouterFactory();
        MarkDao markDAO = new MarkDao();
        Integer userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));
        CreatureListSorter creatureListSorter = new CreatureListSorter();
        parameterMap.putIfAbsent(ParameterConstant.SORT_PARAMETER, CreatureColumn.NAME);
        CreatureListSorter.CreatureSortType sortType = CreatureListSorter.CreatureSortType.valueOf(parameterMap.get(ParameterConstant.SORT_PARAMETER));

        try {
            List<Creature> creatureList = creaturesDAO.findAll();
            creatureList.forEach(creature -> {
                if(creature.getImage()!=null){
                    creature.setEncodedImage(Base64.getEncoder().encodeToString(creature.getImage()));
                }
            });
            ClientRole clientRole = ClientRole.valueOf(parameterMap.get(ParameterConstant.ROLE_PARAMETER));
            String route=null;

            switch (clientRole){
                case USER:
                    route = PagePath.CREATURES_FOR_USER_PAGE;
                    List<Mark> markList = markDAO.findMarks(userId);
                    creatureList.forEach(creature -> {

                        for(Mark mark : markList){

                            if(creature.getCreatureId().equals(mark.getCreatureId())){
                                creature.setMarked(true);
                            }
                        }
                    });
                    break;
                case ADMIN:
                    route = PagePath.CREATURES_FOR_ADMIN_PAGE;
                    break;
            }
            creatureListSorter.sortCreatureList(creatureList,sortType);
            attributeMap.put(AttributeConstant.CREATURE_LIST_ATTRIBUTE,creatureList);
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                    .createRouter(Router.RouteType.FORWARD,route));
        } catch (DaoException e) {
            LOGGER.error("Can not show all creatures.",e);
        }
    }
}

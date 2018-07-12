package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.impl.CreaturesDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.impl.MarkDAO;
import com.epam.creatures.entity.ClientRole;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.Mark;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class ShowCreaturesService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(ShowCreaturesService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        CreaturesDAO creaturesDAO = new CreaturesDAO();
        RouterFactory routerFactory = new RouterFactory();
        MarkDAO markDAO = new MarkDAO();
        Integer userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));

        try {
            List<Creature> creatureList = creaturesDAO.findAll();
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
            attributeMap.put(AttributeConstant.CREATURE_LIST_ATTRIBUTE,creatureList);
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                    .createRouter(Router.RouteType.FORWARD,route));
        } catch (DAOException e) {
            LOGGER.error("Can not show all creatures.",e);
        }
    }
}

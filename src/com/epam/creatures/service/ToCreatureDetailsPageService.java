package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.impl.CreaturesDAO;
import com.epam.creatures.entity.ClientRole;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Base64;
import java.util.Map;

public class ToCreatureDetailsPageService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(ToCreatureDetailsPageService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        CreaturesDAO creaturesDAO = new CreaturesDAO();
        RouterFactory routerFactory = new RouterFactory();
        Integer id = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        Creature creature = null;
        try {
            creature = creaturesDAO.findEntityById(id);

            if(creature.getImage()!=null){
                creature.setEncodedImage(Base64.getEncoder().encodeToString(creature.getImage()));
            }
        } catch (DAOException e) {
            LOGGER.error(e);
        }
        ClientRole clientRole = ClientRole.valueOf(parameterMap.get(ParameterConstant.ROLE_PARAMETER));
        String route=null;

        switch (clientRole){
            case USER:
                route=PagePath.USER_CREATURE_DETAILS_PAGE;
                break;
            case ADMIN:
                route=PagePath.ADMIN_CREATURE_DETAILS_PAGE;
                break;
        }
        attributeMap.put(AttributeConstant.CREATURE_ATTRIBUTE,creature);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.FORWARD,route));
    }
}

package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.impl.CreaturesDao;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.ProjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * The type Delete creature service.
 */
public class DeleteCreatureService implements ProjectService {
    private static final Logger LOGGER = LogManager.getLogger(DeleteCreatureService.class);

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        CreaturesDao creaturesDAO = new CreaturesDao();
        int creatureId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));

        try{

            creaturesDAO.delete(creatureId);
        } catch (DaoException e) {
            LOGGER.error(e);
        }
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.REDIRECT,PagePath.ADMIN_MAIN_PAGE));
    }
}

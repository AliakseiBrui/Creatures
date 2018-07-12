package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.impl.UserDAO;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;
import com.epam.creatures.service.ShowCreaturesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ShowUsersService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(ShowCreaturesService.class);

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        UserDAO userDAO = new UserDAO();
        RouterFactory routerFactory = new RouterFactory();

        try {
            attributeMap.put(AttributeConstant.USER_LIST_ATTRIBUTE,userDAO.findAll());

            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                    .createRouter(Router.RouteType.FORWARD,PagePath.USERS_FOR_ADMIN_PAGE));
        } catch (DAOException e) {
            LOGGER.error("Can not show all users.",e);
        }
    }
}

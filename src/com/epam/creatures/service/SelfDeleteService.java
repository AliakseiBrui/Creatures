package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.AdminDao;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.entity.ClientRole;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class SelfDeleteService implements ProjectService {
    private static final String LOG_OUT_PATH = "/creatures?commandType=LOG_OUT_COMMAND";
    private static final Logger LOGGER = LogManager.getLogger(SelfDeleteService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        StringBuilder errorMessage = new StringBuilder();
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.USER_MAIN_PAGE;
        Integer id = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));
        ClientRole role = ClientRole.valueOf(parameterMap.get(ParameterConstant.ROLE_PARAMETER));

        try {

            if (role == ClientRole.USER) {
                UserDao userDAO = new UserDao();

                if (userDAO.delete(id)) {
                    routeType = Router.RouteType.REDIRECT;
                    route = LOG_OUT_PATH;
                } else {
                    errorMessage.append("Could not delete user.");
                }
            } else if (role == ClientRole.ADMIN) {
                AdminDao adminDAO = new AdminDao();

                if (adminDAO.delete(id)) {
                    routeType = Router.RouteType.REDIRECT;
                    route = LOG_OUT_PATH;
                } else {
                    errorMessage.append("Could not delete admin.");
                }
            }
        } catch (DaoException e) {
            errorMessage.append(e.getLocalizedMessage()).append(".");
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(routeType,route));
    }
}

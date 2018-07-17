package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.impl.UserDAO;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class SelfDeleteService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(SelfDeleteService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        UserDAO userDAO = new UserDAO();
        Integer userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.USER_MAIN_PAGE;
        try {

            if(userDAO.delete(userId)){
                routeType = Router.RouteType.REDIRECT;
                route = "/creatures?commandType=LOG_OUT_COMMAND";
            }else{
                errorMessage.append("Could not delete user.");
            }
        } catch (DAOException e) {
            LOGGER.debug(e);
            errorMessage.append(e).append(".");
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(routeType,route));
    }
}

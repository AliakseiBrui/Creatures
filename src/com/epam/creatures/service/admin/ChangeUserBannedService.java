package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.UserDAO;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ChangeUserBannedService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(ChangeUserBannedService.class);

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        UserDAO userDAO = new UserDAO();
        int userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));

        try{

            User user = userDAO.findEntityById(userId);

            if(user!=null) {

                user.setBanned(!user.getBanned());
                userDAO.updateUserBan(user);
            }
        }catch (DAOException e){
            LOGGER.error(e);
        }
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.REDIRECT,PagePath.ADMIN_MAIN_PAGE));
    }
}

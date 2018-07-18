package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.ProjectService;
import com.epam.creatures.service.ShowCreaturesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Base64;
import java.util.List;
import java.util.Map;

public class ShowUsersService implements ProjectService {
    private static final Logger LOGGER = LogManager.getLogger(ShowCreaturesService.class);

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        UserDao userDAO = new UserDao();
        RouterFactory routerFactory = new RouterFactory();

        try {
            List<User> userList = userDAO.findAll();
            userList.forEach(user -> {

                if(user.getAvatar()!=null){
                    user.setEncodedAvatar(Base64.getEncoder().encodeToString(user.getAvatar()));
                }
            });
            attributeMap.put(AttributeConstant.USER_LIST_ATTRIBUTE,userList);

            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                    .createRouter(Router.RouteType.FORWARD,PagePath.USERS_FOR_ADMIN_PAGE));
        } catch (DaoException e) {
            LOGGER.error("Can not show all users.",e);
        }
    }
}

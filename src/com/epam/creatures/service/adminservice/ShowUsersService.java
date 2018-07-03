package com.epam.creatures.service.adminservice;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.UserDAO;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;
import com.epam.creatures.service.ShowCreaturesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class ShowUsersService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(ShowCreaturesService.class);
    private UserDAO userDAO = new UserDAO();
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) throws ServletException, IOException {

        try {
            attributeMap.put(AttributeConstant.USER_LIST_ATTRIBUTE,userDAO.findAll());

            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,new Router(Router.RouteType.FORWARD,PagePath.USERS_FOR_ADMIN_PAGE));
        } catch (DAOException e) {
            LOGGER.error("Can not show all users.",e);
        }
    }
}

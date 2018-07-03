package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.CreaturesDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.entity.Role;
import com.epam.creatures.entity.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class ShowCreaturesService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(ShowCreaturesService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) throws ServletException, IOException {
        CreaturesDAO creaturesDAO = new CreaturesDAO();

        try {
            attributeMap.put(AttributeConstant.CREATURE_LIST_ATTRIBUTE,creaturesDAO.findAll());
            Role role = Role.valueOf(parameterMap.get(ParameterConstant.ROLE_PARAMETER));
            String route=null;

            switch (role){
                case USER:
                    route = PagePath.CREATURES_FOR_USER_PAGE;
                    break;
                case ADMIN:
                    route = PagePath.CREATURES_FOR_ADMIN_PAGE;
                    break;
            }
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,new Router(Router.RouteType.FORWARD,route));
        } catch (DAOException e) {
            LOGGER.error("Can not show all creatures.",e);
        }
    }
}

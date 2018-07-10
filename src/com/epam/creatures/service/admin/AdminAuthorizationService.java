package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.encoder.PasswordEncoder;
import com.epam.creatures.entity.Admin;
import com.epam.creatures.entity.Role;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.AdminFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;
import com.epam.creatures.validator.AdminValidator;

import java.util.Map;

public class AdminAuthorizationService implements CommandService {

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {

        PasswordEncoder passwordEncoder = new PasswordEncoder();
        RouterFactory routerFactory = new RouterFactory();
        AdminFactory adminFactory = new AdminFactory();
        AdminValidator adminValidator = new AdminValidator();
        String login = parameterMap.get(ParameterConstant.LOGIN_PARAMETER);
        String password = passwordEncoder.encryptPassword(parameterMap.get(ParameterConstant.PASSWORD_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();
        Admin admin = adminFactory.createAdmin(login,password);
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.ADMIN_AUTHORIZATION_PAGE;

        try {

            if(adminValidator.validateAdminLogin(admin)){
                attributeMap.put(AttributeConstant.LOGIN_ATTRIBUTE,admin.getLogin());
                attributeMap.put(AttributeConstant.ID_ATTRIBUTE,admin.getId());
                attributeMap.put(AttributeConstant.ROLE_ATTRIBUTE,Role.ADMIN);
                //put avatar as well
                routeType=Router.RouteType.REDIRECT;
                route=PagePath.ADMIN_MAIN_PAGE;
            }else{
                errorMessage.append("Wrong login or password.");
                attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
            }
        } catch (DAOException e) {
            errorMessage.append(e.getSQLState()).append(";").append(e);
        }
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(routeType,route));
    }
}

package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.impl.AdminDao;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.encoder.PasswordEncoder;
import com.epam.creatures.entity.Admin;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.AdminFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;
import com.epam.creatures.validator.ClientDataValidator;

import java.util.Map;

public class CreateAdminService implements CommandService {

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        AdminFactory adminFactory = new AdminFactory();
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        AdminDao adminDAO = new AdminDao();
        ClientDataValidator clientDataValidator = new ClientDataValidator();
        RouterFactory routerFactory = new RouterFactory();
        String login = parameterMap.get(ParameterConstant.LOGIN_PARAMETER);
        String encryptedPassword = passwordEncoder.encryptPassword(parameterMap.get(ParameterConstant.PASSWORD_PARAMETER));
        Admin admin = adminFactory.createAdmin(login,encryptedPassword);
        StringBuilder errorMessage = new StringBuilder();
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.CREATE_ADMIN_PAGE;

        try {

            if(clientDataValidator.validateLogin(login)) {

                if (adminDAO.create(admin)) {
                    routeType=Router.RouteType.REDIRECT;
                    route=PagePath.ADMIN_MAIN_PAGE;
                } else {
                    errorMessage.append("Could not create admin.");
                }
            }else{
                errorMessage.append("Wrong data in login field.");
            }
        } catch (DaoException e) {
            errorMessage.append(e.getLocalizedMessage()).append(".");
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(routeType,route));
    }
}

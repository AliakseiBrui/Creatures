package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.AdminDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.encoder.PasswordEncoder;
import com.epam.creatures.entity.Admin;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.AdminFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import java.util.Map;

public class CreateAdminService implements CommandService {

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        AdminFactory adminFactory = new AdminFactory();
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        AdminDAO adminDAO = new AdminDAO();
        RouterFactory routerFactory = new RouterFactory();
        String login = parameterMap.get(ParameterConstant.LOGIN_PARAMETER);
        String encryptedPassword = passwordEncoder.encryptPassword(parameterMap.get(ParameterConstant.PASSWORD_PARAMETER));
        Admin admin = adminFactory.createAdmin(login,encryptedPassword);
        StringBuilder message = new StringBuilder();
        StringBuilder errorMessage = new StringBuilder();

        try {

            if(adminDAO.create(admin)){
                message.append("Admin has been created.");
            }else{
                errorMessage.append("Could not create admin.");
            }

        } catch (DAOException e) {
            errorMessage.append(e.getSQLState()).append(";").append(e);
        }

        attributeMap.put(AttributeConstant.MESSAGE_ATTRIBUTE,message);
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.FORWARD,PagePath.ADMIN_MAIN_PAGE));
    }
}

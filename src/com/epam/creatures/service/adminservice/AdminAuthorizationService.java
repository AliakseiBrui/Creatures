package com.epam.creatures.service.adminservice;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.AdminDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.encoder.PasswordEncoder;
import com.epam.creatures.entity.Admin;
import com.epam.creatures.entity.Role;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.AdminFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class AdminAuthorizationService implements CommandService {
    private AdminDAO adminDAO = new AdminDAO();
    private PasswordEncoder passwordEncoder = new PasswordEncoder();
    private RouterFactory routerFactory = new RouterFactory();
    private AdminFactory adminFactory = new AdminFactory();

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) throws ServletException, IOException {
        String login = parameterMap.get(ParameterConstant.LOGIN_PARAMETER);
        String password = passwordEncoder.encryptPassword(parameterMap.get(ParameterConstant.PASSWORD_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();
        Admin admin = adminFactory.createAdmin();

        if(checkAdmin(login,password,admin,errorMessage)){
            attributeMap.put(AttributeConstant.LOGIN_ATTRIBUTE,admin.getLogin());
            attributeMap.put(AttributeConstant.ID_ATTRIBUTE,admin.getId());
            attributeMap.put(AttributeConstant.ROLE_ATTRIBUTE,Role.ADMIN);
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.REDIRECT,PagePath.ADMIN_MAIN_PAGE));
            //put avatar as well
        }else{
            errorMessage.append("Wrong login or password.");
            attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.FORWARD,PagePath.ADMIN_AUTHORIZATION_PAGE));
        }
    }

    private boolean checkAdmin(String login, String password, Admin admin, StringBuilder errorMessage){

        try {
            Admin currentAdmin = adminDAO.findAdminByLogin(login);

            if(currentAdmin!=null && currentAdmin.getPassword().equals(password)){
                admin.setId(currentAdmin.getId());
                admin.setLogin(currentAdmin.getLogin());
                admin.setPassword(currentAdmin.getPassword());
                return true;
            }
        } catch (DAOException e) {
            errorMessage.append(e);
        }
        return false;
    }
}

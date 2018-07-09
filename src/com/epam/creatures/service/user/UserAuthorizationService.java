package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.UserDAO;
import com.epam.creatures.encoder.PasswordEncoder;
import com.epam.creatures.entity.Role;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.factory.UserFactory;
import com.epam.creatures.service.CommandService;

import java.util.Map;

public class UserAuthorizationService implements CommandService {
    private UserDAO userDAO = new UserDAO();
    private PasswordEncoder passwordEncoder = new PasswordEncoder();
    private RouterFactory routerFactory = new RouterFactory();
    private UserFactory userFactory = new UserFactory();

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        String login = parameterMap.get(ParameterConstant.LOGIN_PARAMETER);
        String password = passwordEncoder.encryptPassword(parameterMap.get(ParameterConstant.PASSWORD_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();
        User user = userFactory.createUser();

        if(checkUser(login,password,user,errorMessage)){
            attributeMap.put(AttributeConstant.LOGIN_ATTRIBUTE,user.getLogin());
            attributeMap.put(AttributeConstant.ID_ATTRIBUTE,user.getId());
            attributeMap.put(AttributeConstant.STATUS_ATTRIBUTE,user.getStatus());
            attributeMap.put(AttributeConstant.BANNED_ATTRIBUTE,user.getBanned());
            attributeMap.put(AttributeConstant.ROLE_ATTRIBUTE,Role.USER);
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.REDIRECT,PagePath.USER_MAIN_PAGE));
            //put avatar as well
        }else{
            errorMessage.append("Wrong login or password.");
            attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.FORWARD,PagePath.USER_AUTHORIZATION_PAGE));
        }
    }

    private boolean checkUser(String login, String password, User user, StringBuilder errorMessage){

        try {
            User currentUser = userDAO.findUserByLogin(login);

            if(currentUser!=null && currentUser.getPassword().equals(password)){
                user.setId(currentUser.getId());
                user.setLogin(currentUser.getLogin());
                user.setPassword(currentUser.getPassword());
                user.setStatus(currentUser.getStatus());
                user.setBanned(currentUser.getBanned());
                return true;
            }
        } catch (DAOException e) {
            errorMessage.append(e.getSQLState()).append(";").append(e);
        }
        return false;
    }
}

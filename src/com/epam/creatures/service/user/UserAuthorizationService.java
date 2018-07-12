package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.encoder.PasswordEncoder;
import com.epam.creatures.entity.Role;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.exception.UserBannedException;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.factory.UserFactory;
import com.epam.creatures.service.CommandService;
import com.epam.creatures.validator.DataValidator;
import com.epam.creatures.validator.UserValidator;

import java.util.Map;

public class UserAuthorizationService implements CommandService {

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        RouterFactory routerFactory = new RouterFactory();
        UserFactory userFactory = new UserFactory();
        DataValidator dataValidator = new DataValidator();
        UserValidator userValidator = new UserValidator();
        String login = parameterMap.get(ParameterConstant.LOGIN_PARAMETER);
        String password = passwordEncoder.encryptPassword(parameterMap.get(ParameterConstant.PASSWORD_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();
        User user = userFactory.createUser(login,password);
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.USER_AUTHORIZATION_PAGE;

        try {

            if(dataValidator.validateLogin(login)) {

                if (userValidator.validateUser(user)) {
                    attributeMap.put(AttributeConstant.LOGIN_ATTRIBUTE, user.getLogin());
                    attributeMap.put(AttributeConstant.ID_ATTRIBUTE, user.getId());
                    attributeMap.put(AttributeConstant.STATUS_ATTRIBUTE, user.getStatus());
                    attributeMap.put(AttributeConstant.BANNED_ATTRIBUTE, user.getBanned());
                    attributeMap.put(AttributeConstant.ROLE_ATTRIBUTE, Role.USER);
                    //put avatar as well
                    routeType = Router.RouteType.REDIRECT;
                    route = PagePath.USER_MAIN_PAGE;

                } else {
                    errorMessage.append("Wrong login or password.");
                }
            }else{
                errorMessage.append("Wrong data in login field.");
            }
        } catch (DAOException e) {
            errorMessage.append(e.getSQLState()).append(";").append(e);
        } catch (UserBannedException e) {
            errorMessage.append("Your account is banned.");
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(routeType,route));
    }
}

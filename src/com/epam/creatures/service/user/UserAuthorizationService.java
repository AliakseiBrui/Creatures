package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.encoder.PasswordEncoder;
import com.epam.creatures.entity.ClientRole;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.exception.UserBannedException;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.factory.UserFactory;
import com.epam.creatures.service.CommandService;
import com.epam.creatures.validator.ClientDataValidator;
import com.epam.creatures.validator.UserValidator;

import java.util.Base64;
import java.util.Map;

public class UserAuthorizationService implements CommandService {

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        RouterFactory routerFactory = new RouterFactory();
        UserFactory userFactory = new UserFactory();
        ClientDataValidator clientDataValidator = new ClientDataValidator();
        UserValidator userValidator = new UserValidator();
        String login = parameterMap.get(ParameterConstant.LOGIN_PARAMETER);
        String password = passwordEncoder.encryptPassword(parameterMap.get(ParameterConstant.PASSWORD_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();
        User user = userFactory.createUser(login,password);
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.USER_AUTHORIZATION_PAGE;

        try {

            if(clientDataValidator.validateLogin(login)) {

                if (userValidator.validateUser(user)) {
                    attributeMap.put(AttributeConstant.LOGIN_ATTRIBUTE, user.getLogin());
                    attributeMap.put(AttributeConstant.ID_ATTRIBUTE, user.getId());
                    attributeMap.put(AttributeConstant.STATUS_ATTRIBUTE, user.getStatus());
                    attributeMap.put(AttributeConstant.BANNED_ATTRIBUTE, user.getBanned());
                    attributeMap.put(AttributeConstant.ROLE_ATTRIBUTE, ClientRole.USER);

                    if(user.getAvatar()!=null) {
                        attributeMap.put(AttributeConstant.AVATAR_ATTRIBUTE,Base64.getEncoder().encodeToString(user.getAvatar()));
                    }
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

package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.encoder.PasswordEncoder;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.factory.UserFactory;
import com.epam.creatures.service.CommandService;
import com.epam.creatures.validator.ClientDataValidator;

import java.util.Map;

public class UserRegistrationService implements CommandService {


    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        UserFactory userFactory = new UserFactory();
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        RouterFactory routerFactory = new RouterFactory();
        UserDao userDAO = new UserDao();
        ClientDataValidator clientDataValidator = new ClientDataValidator();
        String login = parameterMap.get(ParameterConstant.LOGIN_PARAMETER);
        String encryptedPassword = passwordEncoder.encryptPassword(parameterMap.get(ParameterConstant.PASSWORD_PARAMETER));
        User user = userFactory.createUser(login,encryptedPassword);
        StringBuilder message = new StringBuilder();
        StringBuilder errorMessage = new StringBuilder();

        try {

            if(clientDataValidator.validateLogin(login)) {

                if (userDAO.create(user)) {
                    message.append("Registration succeeded.");
                } else {
                    errorMessage.append("Could not register user.");
                }
            }else{
                errorMessage.append("Wrong data in login field.");
            }
        } catch (DaoException e) {
            errorMessage.append(e.getSQLState()).append(";").append(e);
        }

        attributeMap.put(AttributeConstant.MESSAGE_ATTRIBUTE,message);
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.FORWARD,PagePath.START_PAGE));

    }
}

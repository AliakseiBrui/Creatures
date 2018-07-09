package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.UserDAO;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import java.util.Map;

public class ChangeUserBannedService implements CommandService {

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        UserDAO userDAO = new UserDAO();
        int userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));
        StringBuilder message = new StringBuilder();
        StringBuilder errorMessage = new StringBuilder();

        try{

            User user = userDAO.findEntityById(userId);

            if(user!=null) {

                user.setBanned(!user.getBanned());
                if (userDAO.updateUserBan(user)) {
                    message.append("Success");
                } else {
                    errorMessage.append("Something went wrong.");
                }
            }else{
                errorMessage.append("Something went wrong.");
            }
        }catch (DAOException e){
            errorMessage.append(e.getSQLState()).append(";").append(e);
        }
        attributeMap.put(AttributeConstant.MESSAGE_ATTRIBUTE,message);
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.FORWARD,PagePath.ADMIN_MAIN_PAGE));
    }
}

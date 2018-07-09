package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.MarkDAO;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.MarkFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import java.util.Map;

public class LikeCreatureService implements CommandService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        MarkDAO markDAO = new MarkDAO();
        MarkFactory markFactory = new MarkFactory();
        Double value = Double.parseDouble(parameterMap.get(ParameterConstant.MARK_PARAMETER));
        Integer creatureId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        Integer userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();

        try {
            markDAO.create(markFactory.createMark(value,creatureId,userId));
        } catch (DAOException e) {
            errorMessage.append(e.getSQLState()).append(";").append(e);
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.REDIRECT,PagePath.USER_MAIN_PAGE));
    }
}

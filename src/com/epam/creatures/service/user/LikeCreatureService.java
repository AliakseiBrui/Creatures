package com.epam.creatures.service.user;

import com.epam.creatures.action.UserStatusCalculator;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.CreaturesDao;
import com.epam.creatures.dao.impl.MarkDao;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.Router;
import com.epam.creatures.entity.User;
import com.epam.creatures.factory.MarkFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Objects;

public class LikeCreatureService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(LikeCreatureService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        MarkDao markDAO = new MarkDao();
        CreaturesDao creaturesDAO = new CreaturesDao();
        UserDao userDAO = new UserDao();
        MarkFactory markFactory = new MarkFactory();
        Double value = Double.parseDouble(parameterMap.get(ParameterConstant.MARK_PARAMETER));
        Integer creatureId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        Integer userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();
        UserStatusCalculator userStatusCalculator = new UserStatusCalculator();
        User user=null;
        try {
            Creature creature = creaturesDAO.findEntityById(creatureId);
            markDAO.create(markFactory.createMark(value,creatureId,userId, userStatusCalculator.calculateStatus(value,creature.getCreatureRating())));
            user = userDAO.findEntityById(userId);
        } catch (DaoException e) {
            LOGGER.error(e);
            errorMessage.append(e.getSQLState()).append(";").append(e);
        }
        attributeMap.put(AttributeConstant.STATUS_ATTRIBUTE,Objects.requireNonNull(user).getStatus());
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.REDIRECT,PagePath.USER_MAIN_PAGE));
    }
}

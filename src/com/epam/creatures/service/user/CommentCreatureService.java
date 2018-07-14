package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.impl.CommentDAO;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.CommentFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.factory.UserFactory;
import com.epam.creatures.service.CommandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class CommentCreatureService implements CommandService {
    private static final Logger LOGGER = LogManager.getLogger(CommentCreatureService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        UserFactory userFactory = new UserFactory();
        CommentDAO commentDAO = new CommentDAO();
        RouterFactory routerFactory = new RouterFactory();
        CommentFactory commentFactory = new CommentFactory();
        String commentData = parameterMap.get(ParameterConstant.COMMENT_PARAMETER);
        Integer creatureId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        Integer  userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));


        try {
            commentDAO.create(commentFactory.createComment(commentData,creatureId,userFactory.createUser(userId)));
        } catch (DAOException e) {
            LOGGER.error("Exception while commenting creature.",e);
        }
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.REDIRECT,PagePath.USER_MAIN_PAGE));
    }
}

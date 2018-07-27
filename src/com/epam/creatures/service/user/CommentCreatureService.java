package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.CommentDao;
import com.epam.creatures.entity.Comment;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.CommentFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.factory.UserFactory;
import com.epam.creatures.service.ProjectService;
import com.epam.creatures.validator.CommentValidator;
import com.epam.creatures.validator.XssValidator;

import java.util.Map;

public class CommentCreatureService implements ProjectService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        UserFactory userFactory = new UserFactory();
        CommentDao commentDAO = new CommentDao();
        RouterFactory routerFactory = new RouterFactory();
        CommentFactory commentFactory = new CommentFactory();
        String commentData = parameterMap.get(ParameterConstant.COMMENT_PARAMETER);
        Integer creatureId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        Integer  userId = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));
        StringBuilder errorMessage = new StringBuilder();
        CommentValidator commentValidator = new CommentValidator();
        XssValidator xssValidator = new XssValidator();
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.USER_MAIN_PAGE;

        try {

            if(xssValidator.checkForXssAttack(commentData)) {
                Comment comment = commentFactory.createComment(commentData, creatureId, userFactory.createUser(userId));

                if (commentValidator.validateComment(comment)) {

                    if (commentDAO.create(comment)) {
                        routeType = Router.RouteType.REDIRECT;
                    } else {
                        errorMessage.append("Could not create comment.");
                    }
                } else {
                    errorMessage.append("Wrong data.");
                }
            }else{
                errorMessage.append("XSS attack attempt.");
            }
        } catch (DaoException e) {
            errorMessage.append(e.getLocalizedMessage()).append(".");
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(routeType,route));
    }
}

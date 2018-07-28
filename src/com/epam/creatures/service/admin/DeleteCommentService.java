package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.CommentDao;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.ProjectService;

import java.util.Map;

/**
 * The type Delete comment service.
 */
public class DeleteCommentService implements ProjectService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        CommentDao commentDao = new CommentDao();
        StringBuilder errorMessage = new StringBuilder();
        Integer commentId = Integer.parseInt(parameterMap.get(ParameterConstant.COMMENT_ID_PARAMETER));
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.ADMIN_MAIN_PAGE;

        try {

            if (commentDao.delete(commentId)) {
                routeType=Router.RouteType.REDIRECT;
            }else{
                errorMessage.append("Could not delete comment.");
            }
        } catch (DaoException e) {
            errorMessage.append(e.getLocalizedMessage()).append(".");
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(routeType,route));
    }
}

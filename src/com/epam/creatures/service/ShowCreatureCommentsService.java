package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.CommentDao;
import com.epam.creatures.entity.ClientRole;
import com.epam.creatures.entity.Comment;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Base64;
import java.util.List;
import java.util.Map;

public class ShowCreatureCommentsService implements ProjectService {
    private static final Logger LOGGER = LogManager.getLogger(ShowCreatureCommentsService.class);
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        CommentDao commentDAO = new CommentDao();
        RouterFactory routerFactory = new RouterFactory();

        try {
            Integer creatureId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
            List<Comment> commentList = commentDAO.findCommentsByCreatureId(creatureId);
            commentList.forEach(comment -> {
                if(comment.getUser()!=null && comment.getUser().getAvatar()!=null){

                    comment.getUser().setEncodedAvatar(Base64.getEncoder().encodeToString(comment.getUser().getAvatar()));
                }
            });
            attributeMap.put(AttributeConstant.COMMENT_LIST_ATTRIBUTE,commentList);
            ClientRole clientRole = ClientRole.valueOf(parameterMap.get(ParameterConstant.ROLE_PARAMETER));
            String route=PagePath.START_PAGE;

            if (clientRole == ClientRole.USER) {
                route = PagePath.COMMENTS_FOR_USER_PAGE;

            } else if (clientRole == ClientRole.ADMIN) {
                route = PagePath.COMMENTS_FOR_ADMIN_PAGE;

            }
            attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                    .createRouter(Router.RouteType.FORWARD,route));
        } catch (DaoException e) {
            LOGGER.error("Can not show all comments.",e);
        }
    }
}

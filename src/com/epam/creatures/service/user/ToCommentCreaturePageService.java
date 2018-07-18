package com.epam.creatures.service.user;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.ProjectService;

import java.util.Map;

public class ToCommentCreaturePageService implements ProjectService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();


        attributeMap.put(AttributeConstant.CREATURE_ID_ATTRIBUTE,parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.FORWARD,PagePath.CREATE_COMMENT_PAGE));
    }
}

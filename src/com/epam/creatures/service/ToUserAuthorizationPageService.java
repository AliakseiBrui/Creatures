package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;

import java.util.Map;

public class ToUserAuthorizationPageService implements CommandService {
    private RouterFactory routerFactory = new RouterFactory();
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.REDIRECT,PagePath.USER_AUTHORIZATION_PAGE));
    }
}

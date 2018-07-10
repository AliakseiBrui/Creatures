package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;

import java.util.Map;

public class FakeForwardService implements CommandService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        RouterFactory routerFactory = new RouterFactory();
        String page = parameterMap.get(ParameterConstant.PAGE_PARAMETER);
        String message = parameterMap.get(ParameterConstant.MESSAGE_PARAMETER);
        String errorMessage = parameterMap.get(ParameterConstant.ERROR_MESSAGE_PARAMETER);

        attributeMap.put(AttributeConstant.MESSAGE_ATTRIBUTE,message);
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.FORWARD,page));
    }
}

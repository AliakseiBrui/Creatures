package com.epam.creatures.service.adminservice;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.CreatureFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class ToUpdateCreaturePageService implements CommandService {
    private CreatureFactory creatureFactory = new CreatureFactory();
    private RouterFactory routerFactory = new RouterFactory();
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) throws ServletException, IOException {
        int id = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        String name = parameterMap.get(ParameterConstant.CREATURE_NAME_PARAMETER);
        int limbQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_LIMB_Q_PARAMETER));
        int headQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_HEAD_Q_PARAMETER));
        int eyeQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_EYE_Q_PARAMETER));
        Creature.Gender gender = Creature.Gender.valueOf(parameterMap.get(ParameterConstant.CREATURE_GENDER_PARAMETER));
        String description = parameterMap.get(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER);
        Creature creature = creatureFactory.createCreature(id,name,limbQuantity,headQuantity,eyeQuantity,gender,description);

        attributeMap.put(AttributeConstant.CREATURE_ATTRIBUTE,creature);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.FORWARD,PagePath.UPDATE_CREATURE_PAGE));
    }
}

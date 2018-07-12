package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.ClientRole;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.CreatureFactory;
import com.epam.creatures.factory.RouterFactory;

import java.util.Map;

public class ToCreatureDetailsPageService implements CommandService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        CreatureFactory creatureFactory = new CreatureFactory();
        RouterFactory routerFactory = new RouterFactory();
        Integer id = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        String name = parameterMap.get(ParameterConstant.CREATURE_NAME_PARAMETER);
        Integer limbQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_LIMB_Q_PARAMETER));
        Integer headQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_HEAD_Q_PARAMETER));
        Integer eyeQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_EYE_Q_PARAMETER));
        Creature.Gender gender = Creature.Gender.valueOf(parameterMap.get(ParameterConstant.CREATURE_GENDER_PARAMETER));
        String description = parameterMap.get(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER);
        Integer creatorId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATOR_ID_PARAMETER));
        Double creatureRating = Double.parseDouble(parameterMap.get(ParameterConstant.CREATURE_RATING_PARAMETER));
        Creature creature = creatureFactory.createCreature(id,name,limbQuantity,headQuantity,eyeQuantity,gender,description,creatureRating,creatorId);
        ClientRole clientRole = ClientRole.valueOf(parameterMap.get(ParameterConstant.ROLE_PARAMETER));
        String route=null;

        switch (clientRole){
            case USER:
                route=PagePath.USER_CREATURE_DETAILS_PAGE;
                break;
            case ADMIN:
                route=PagePath.ADMIN_CREATURE_DETAILS_PAGE;
                break;
        }
        attributeMap.put(AttributeConstant.CREATURE_ATTRIBUTE,creature);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.FORWARD,route));
    }
}

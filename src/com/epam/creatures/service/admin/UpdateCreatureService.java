package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.impl.CreaturesDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.CreatureFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import java.util.Map;

public class UpdateCreatureService implements CommandService {

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        CreatureFactory creatureFactory = new CreatureFactory();
        RouterFactory routerFactory = new RouterFactory();
        CreaturesDAO creaturesDAO = new CreaturesDAO();
        int id = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        String name = parameterMap.get(ParameterConstant.CREATURE_NAME_PARAMETER);
        int limbQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_LIMB_Q_PARAMETER));
        int headQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_HEAD_Q_PARAMETER));
        int eyeQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_EYE_Q_PARAMETER));
        Creature.Gender gender = Creature.Gender.valueOf(parameterMap.get(ParameterConstant.CREATURE_GENDER_PARAMETER));
        String description = parameterMap.get(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER);
        Creature creature = creatureFactory.createCreature(id,name,limbQuantity,headQuantity,eyeQuantity,gender,description);
        StringBuilder message = new StringBuilder();
        StringBuilder errorMessage = new StringBuilder();

        try {

            if(creaturesDAO.update(creature)){
                message.append("Creature has been updated.");
            }else{
                errorMessage.append("Could not update creature.");
            }

        } catch (DAOException e) {
            errorMessage.append(e.getSQLState()).append(";").append(e);
        }

        attributeMap.put(AttributeConstant.MESSAGE_ATTRIBUTE,message);
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.REDIRECT,PagePath.ADMIN_MAIN_PAGE));
    }
}

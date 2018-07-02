package com.epam.creatures.service.adminservice;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.CreaturesDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.CreatureFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class CreateCreatureService implements CommandService {
    private CreatureFactory creatureFactory = new CreatureFactory();
    private RouterFactory routerFactory = new RouterFactory();
    private CreaturesDAO creaturesDAO = new CreaturesDAO();
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) throws ServletException, IOException {
        String name = parameterMap.get(ParameterConstant.CREATURE_NAME_PARAMETER);
        int limbQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_LIMB_Q_PARAMETER));
        int headQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_HEAD_Q_PARAMETER));
        int eyeQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_EYE_Q_PARAMETER));
        Creature.Gender gender = Creature.Gender.valueOf(parameterMap.get(ParameterConstant.CREATURE_GENDER_PARAMETER));
        String description = parameterMap.get(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER);
        int creatorId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATOR_ID_PARAMETER));
        Creature creature = creatureFactory.createCreature(name,limbQuantity,headQuantity,eyeQuantity,gender,description,creatorId);
        StringBuilder errorMessage = new StringBuilder();

        try {

            if(!creaturesDAO.create(creature)){
                errorMessage.append("Could not create creature.");
            }

        } catch (DAOException e) {
            errorMessage.append(e);
        }

        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(Router.RouteType.FORWARD,PagePath.ADMIN_MAIN_PAGE));
    }
}

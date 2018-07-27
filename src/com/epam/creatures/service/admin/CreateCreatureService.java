package com.epam.creatures.service.admin;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.CreaturesDao;
import com.epam.creatures.entity.Creature;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.CreatureFactory;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.ProjectService;
import com.epam.creatures.validator.CreatureValidator;
import com.epam.creatures.validator.XssValidator;

import java.util.Map;

public class CreateCreatureService implements ProjectService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        CreatureFactory creatureFactory = new CreatureFactory();
        RouterFactory routerFactory = new RouterFactory();
        CreaturesDao creaturesDAO = new CreaturesDao();
        String name = parameterMap.get(ParameterConstant.CREATURE_NAME_PARAMETER);
        int limbQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_LIMB_Q_PARAMETER));
        int headQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_HEAD_Q_PARAMETER));
        int eyeQuantity = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_EYE_Q_PARAMETER));
        Creature.Gender gender = Creature.Gender.valueOf(parameterMap.get(ParameterConstant.CREATURE_GENDER_PARAMETER));
        String description = parameterMap.get(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER);
        int creatorId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATOR_ID_PARAMETER));
        Creature creature = creatureFactory.createCreature(name,limbQuantity,headQuantity,eyeQuantity,gender,description,creatorId);
        StringBuilder errorMessage = new StringBuilder();
        CreatureValidator creatureValidator = new CreatureValidator();
        XssValidator xssValidator = new XssValidator();
        Router.RouteType routeType = Router.RouteType.FORWARD;
        String route = PagePath.CREATE_CREATURE_PAGE;

        try {

            if(xssValidator.checkForXssAttack(name)&&(description==null||xssValidator.checkForXssAttack(description))) {

                if (creatureValidator.validateCreature(creature)) {

                    if (creaturesDAO.create(creature)) {
                        routeType = Router.RouteType.REDIRECT;
                        route = PagePath.ADMIN_MAIN_PAGE;
                    } else {
                        errorMessage.append("Could not create creature.");
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
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory.createRouter(routeType,route));
    }
}

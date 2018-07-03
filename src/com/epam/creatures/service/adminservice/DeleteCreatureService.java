package com.epam.creatures.service.adminservice;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.dao.CreaturesDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class DeleteCreatureService implements CommandService {
    private RouterFactory routerFactory = new RouterFactory();
    private CreaturesDAO creaturesDAO = new CreaturesDAO();

    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) throws ServletException, IOException {
        int creatureId = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
        StringBuilder message = new StringBuilder();
        StringBuilder errorMessage = new StringBuilder();

        try{

            if(creaturesDAO.delete(creatureId)){
                message.append("Creature has been deleted.");
            }else{
                errorMessage.append("Could not delete creature.");
            }
        } catch (DAOException e) {
            errorMessage.append(e);
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.MESSAGE_ATTRIBUTE,message);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(Router.RouteType.FORWARD,PagePath.ADMIN_MAIN_PAGE));
    }
}

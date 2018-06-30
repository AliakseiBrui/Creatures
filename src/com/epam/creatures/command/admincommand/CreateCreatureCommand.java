package com.epam.creatures.command.admincommand;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

public class CreateCreatureCommand extends AbstractCommand {
    @Override
    public Router execute(HttpServletRequest request) throws ServletException, IOException {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.CREATURE_NAME_PARAMETER,request.getParameter(ParameterConstant.CREATURE_NAME_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_LIMB_Q_PARAMETER,request.getParameter(ParameterConstant.CREATURE_LIMB_Q_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_HEAD_Q_PARAMETER,request.getParameter(ParameterConstant.CREATURE_HEAD_Q_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_EYE_Q_PARAMETER,request.getParameter(ParameterConstant.CREATURE_EYE_Q_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_GENDER_PARAMETER,request.getParameter(ParameterConstant.CREATURE_GENDER_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER,request.getParameter(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER));

        getService().process(parameterMap,attributeMap);

        request.getSession().setAttribute(AttributeConstant.CREATURE_LIST_ATTRIBUTE, attributeMap.get(AttributeConstant.CREATURE_LIST_ATTRIBUTE));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

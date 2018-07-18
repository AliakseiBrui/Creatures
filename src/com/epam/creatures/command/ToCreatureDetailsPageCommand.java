package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ToCreatureDetailsPageCommand extends AbstractCommand {
    public ToCreatureDetailsPageCommand(ProjectService service) {
        super(service);
    }

    public ToCreatureDetailsPageCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.CREATURE_ID_PARAMETER,request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER));
        parameterMap.put(ParameterConstant.ROLE_PARAMETER, String.valueOf(request.getSession().getAttribute(AttributeConstant.ROLE_ATTRIBUTE)));

        getService().process(parameterMap,attributeMap);

        request.setAttribute(AttributeConstant.CREATURE_ATTRIBUTE, attributeMap.get(AttributeConstant.CREATURE_ATTRIBUTE));
        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

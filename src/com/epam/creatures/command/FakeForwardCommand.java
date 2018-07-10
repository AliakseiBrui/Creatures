package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class FakeForwardCommand extends AbstractCommand{
    public FakeForwardCommand(CommandService service) {
        super(service);
    }

    public FakeForwardCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.PAGE_PARAMETER,request.getParameter(ParameterConstant.PAGE_PARAMETER));
        parameterMap.put(ParameterConstant.MESSAGE_PARAMETER,request.getParameter(ParameterConstant.MESSAGE_PARAMETER));
        parameterMap.put(ParameterConstant.ERROR_MESSAGE_PARAMETER,request.getParameter(ParameterConstant.ERROR_MESSAGE_PARAMETER));

        getService().process(parameterMap,attributeMap);

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

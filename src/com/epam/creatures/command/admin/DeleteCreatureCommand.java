package com.epam.creatures.command.admin;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class DeleteCreatureCommand extends AbstractCommand {
    public DeleteCreatureCommand(CommandService service) {
        super(service);
    }

    public DeleteCreatureCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.CREATURE_ID_PARAMETER,request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER));

        getService().process(parameterMap,attributeMap);

        request.setAttribute(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,attributeMap.get(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE));
        request.setAttribute(AttributeConstant.MESSAGE_ATTRIBUTE,attributeMap.get(AttributeConstant.MESSAGE_ATTRIBUTE));
        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

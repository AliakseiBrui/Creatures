package com.epam.creatures.command.usercommand;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

public class UserRegistrationCommand extends AbstractCommand {
    public UserRegistrationCommand(CommandService service) {
        super(service);
    }

    public UserRegistrationCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) throws ServletException, IOException {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();
        parameterMap.put(ParameterConstant.LOGIN_PARAMETER, request.getParameter(ParameterConstant.LOGIN_PARAMETER));
        parameterMap.put(ParameterConstant.PASSWORD_PARAMETER, request.getParameter(ParameterConstant.PASSWORD_PARAMETER));

        getService().process(parameterMap,attributeMap);

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

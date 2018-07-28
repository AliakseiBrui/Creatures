package com.epam.creatures.command.admin;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Change user banned command.
 */
public class ChangeUserBannedCommand extends AbstractCommand implements AdminCommand{
    /**
     * Instantiates a new Change user banned command.
     *
     * @param service the service
     */
    public ChangeUserBannedCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Change user banned command.
     */
    public ChangeUserBannedCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.USER_ID_PARAMETER,request.getParameter(ParameterConstant.USER_ID_PARAMETER));

        getService().process(parameterMap,attributeMap);

        request.setAttribute(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,attributeMap.get(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE));
        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

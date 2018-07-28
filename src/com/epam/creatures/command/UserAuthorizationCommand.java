package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type User authorization command.
 */
public class UserAuthorizationCommand extends AbstractCommand {
    /**
     * Instantiates a new User authorization command.
     *
     * @param service the service
     */
    public UserAuthorizationCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new User authorization command.
     */
    public UserAuthorizationCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();
        parameterMap.put(ParameterConstant.LOGIN_PARAMETER, request.getParameter(ParameterConstant.LOGIN_PARAMETER));
        parameterMap.put(ParameterConstant.PASSWORD_PARAMETER, request.getParameter(ParameterConstant.PASSWORD_PARAMETER));

        getService().process(parameterMap,attributeMap);

        request.getSession().setAttribute(AttributeConstant.LOGIN_ATTRIBUTE,attributeMap.get(AttributeConstant.LOGIN_ATTRIBUTE));
        request.getSession().setAttribute(AttributeConstant.ROLE_ATTRIBUTE,attributeMap.get(AttributeConstant.ROLE_ATTRIBUTE));
        request.getSession().setAttribute(AttributeConstant.STATUS_ATTRIBUTE,attributeMap.get(AttributeConstant.STATUS_ATTRIBUTE));
        request.getSession().setAttribute(AttributeConstant.AVATAR_ATTRIBUTE,attributeMap.get(AttributeConstant.AVATAR_ATTRIBUTE));
        request.getSession().setAttribute(AttributeConstant.ID_ATTRIBUTE,attributeMap.get(AttributeConstant.ID_ATTRIBUTE));
        request.setAttribute(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,attributeMap.get(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE));
        request.setAttribute(AttributeConstant.MESSAGE_ATTRIBUTE,attributeMap.get(AttributeConstant.MESSAGE_ATTRIBUTE));
        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class LogOutCommand extends AbstractCommand {
    public LogOutCommand(CommandService service) {
        super(service);
    }

    public LogOutCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,Object> attributeMap = new HashMap<>();

        getService().process(null,attributeMap);

        request.getSession().removeAttribute(AttributeConstant.ID_ATTRIBUTE);
        request.getSession().removeAttribute(AttributeConstant.AVATAR_ATTRIBUTE);
        request.getSession().removeAttribute(AttributeConstant.STATUS_ATTRIBUTE);
        request.getSession().removeAttribute(AttributeConstant.ROLE_ATTRIBUTE);
        request.getSession().removeAttribute(AttributeConstant.LOGIN_ATTRIBUTE);
        request.getSession().removeAttribute(AttributeConstant.BANNED_ATTRIBUTE);

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

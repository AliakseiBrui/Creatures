package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Log out command.
 */
public class LogOutCommand extends AbstractCommand {
    /**
     * Instantiates a new Log out command.
     *
     * @param service the service
     */
    public LogOutCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Log out command.
     */
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

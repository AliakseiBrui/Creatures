package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Change language command.
 */
public class ChangeLanguageCommand extends AbstractCommand {
    /**
     * Instantiates a new Change language command.
     *
     * @param service the service
     */
    public ChangeLanguageCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Change language command.
     */
    public ChangeLanguageCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,Object> attributeMap = new HashMap<>();

        getService().process(null,attributeMap);

        request.getSession().setAttribute(AttributeConstant.LOCALE_ATTRIBUTE,request.getParameter(ParameterConstant.LOCALE_PARAMETER));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

package com.epam.creatures.command.admin;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type To change creature image page command.
 */
public class ToChangeCreatureImagePageCommand extends AbstractCommand implements AdminCommand {
    /**
     * Instantiates a new To change creature image page command.
     *
     * @param service the service
     */
    public ToChangeCreatureImagePageCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new To change creature image page command.
     */
    public ToChangeCreatureImagePageCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,Object> attributeMap = new HashMap<>();

        getService().process(null,attributeMap);

        request.setAttribute(AttributeConstant.CREATURE_ID_ATTRIBUTE, Integer.parseInt(request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER)));
        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

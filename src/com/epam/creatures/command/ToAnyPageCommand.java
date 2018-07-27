package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type To any page command.
 */
public class ToAnyPageCommand extends AbstractCommand {
    /**
     * Instantiates a new To any page command.
     *
     * @param service the service
     */
    public ToAnyPageCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new To any page command.
     */
    public ToAnyPageCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,Object> attributeMap = new HashMap<>();

        getService().process(null,attributeMap);

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

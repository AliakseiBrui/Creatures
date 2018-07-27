package com.epam.creatures.command.user;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type To comment creature page command.
 */
public class ToCommentCreaturePageCommand extends AbstractCommand {
    /**
     * Instantiates a new To comment creature page command.
     *
     * @param service the service
     */
    public ToCommentCreaturePageCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new To comment creature page command.
     */
    public ToCommentCreaturePageCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.CREATURE_ID_PARAMETER,request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER));

        getService().process(parameterMap,attributeMap);

        request.setAttribute(AttributeConstant.CREATURE_ID_ATTRIBUTE, attributeMap.get(AttributeConstant.CREATURE_ID_ATTRIBUTE));
        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

package com.epam.creatures.command.user;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Comment creature command.
 */
public class CommentCreatureCommand extends AbstractCommand {
    /**
     * Instantiates a new Comment creature command.
     *
     * @param service the service
     */
    public CommentCreatureCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Comment creature command.
     */
    public CommentCreatureCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.COMMENT_PARAMETER,request.getParameter(ParameterConstant.COMMENT_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_ID_PARAMETER,request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER));
        parameterMap.put(ParameterConstant.USER_ID_PARAMETER, String.valueOf(request.getSession().getAttribute(AttributeConstant.ID_ATTRIBUTE)));

        getService().process(parameterMap,attributeMap);

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

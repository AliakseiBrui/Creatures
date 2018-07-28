package com.epam.creatures.command.admin;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Delete comment command.
 */
public class DeleteCommentCommand extends AbstractCommand implements AdminCommand {
    /**
     * Instantiates a new Delete comment command.
     *
     * @param service the service
     */
    public DeleteCommentCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Delete comment command.
     */
    public DeleteCommentCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.COMMENT_ID_PARAMETER,request.getParameter(ParameterConstant.COMMENT_ID_PARAMETER));

        getService().process(parameterMap,attributeMap);

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

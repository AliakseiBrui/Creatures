package com.epam.creatures.command.user;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Like creature command.
 */
public class LikeCreatureCommand extends AbstractCommand {

    /**
     * Instantiates a new Like creature command.
     *
     * @param service the service
     */
    public LikeCreatureCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Like creature command.
     */
    public LikeCreatureCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.MARK_PARAMETER,request.getParameter(ParameterConstant.MARK_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_ID_PARAMETER,request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER));
        parameterMap.put(ParameterConstant.USER_ID_PARAMETER, String.valueOf(request.getSession().getAttribute(AttributeConstant.ID_ATTRIBUTE)));

        getService().process(parameterMap,attributeMap);

        request.getSession().setAttribute(AttributeConstant.STATUS_ATTRIBUTE,attributeMap.get(AttributeConstant.STATUS_ATTRIBUTE));
        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

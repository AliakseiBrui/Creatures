package com.epam.creatures.command.admin;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Update creature command.
 */
public class UpdateCreatureCommand extends AbstractCommand implements AdminCommand {
    /**
     * Instantiates a new Update creature command.
     *
     * @param service the service
     */
    public UpdateCreatureCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Update creature command.
     */
    public UpdateCreatureCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.CREATURE_ID_PARAMETER,request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_NAME_PARAMETER,request.getParameter(ParameterConstant.CREATURE_NAME_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_LIMB_Q_PARAMETER,request.getParameter(ParameterConstant.CREATURE_LIMB_Q_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_HEAD_Q_PARAMETER,request.getParameter(ParameterConstant.CREATURE_HEAD_Q_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_EYE_Q_PARAMETER,request.getParameter(ParameterConstant.CREATURE_EYE_Q_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_GENDER_PARAMETER,request.getParameter(ParameterConstant.CREATURE_GENDER_PARAMETER));
        parameterMap.put(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER,request.getParameter(ParameterConstant.CREATURE_DESCRIPTION_PARAMETER));

        getService().process(parameterMap,attributeMap);

        request.setAttribute(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,attributeMap.get(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE));
        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

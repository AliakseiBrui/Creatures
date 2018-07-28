package com.epam.creatures.command.admin;

import com.epam.creatures.command.AbstractCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * The type Show users command.
 */
public class ShowUsersCommand extends AbstractCommand implements AdminCommand {
    /**
     * Instantiates a new Show users command.
     *
     * @param service the service
     */
    public ShowUsersCommand(ProjectService service) {
        super(service);
    }

    /**
     * Instantiates a new Show users command.
     */
    public ShowUsersCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.SORT_USER_PARAMETER, (String) request.getSession().getAttribute(AttributeConstant.SORT_USER_ATTRIBUTE));

        getService().process(parameterMap,attributeMap);

        request.setAttribute(AttributeConstant.USER_LIST_ATTRIBUTE,attributeMap.get(AttributeConstant.USER_LIST_ATTRIBUTE));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

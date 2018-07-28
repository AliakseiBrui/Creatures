package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ChangeCreatureSortTypeCommand extends AbstractCommand {

    public ChangeCreatureSortTypeCommand(ProjectService service) {
        super(service);
    }

    public ChangeCreatureSortTypeCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,Object> attributeMap = new HashMap<>();

        getService().process(null,attributeMap);

        request.getSession().setAttribute(ParameterConstant.SORT_CREATURE_PARAMETER,request.getParameter(ParameterConstant.SORT_CREATURE_PARAMETER));

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

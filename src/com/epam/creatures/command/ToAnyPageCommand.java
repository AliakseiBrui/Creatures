package com.epam.creatures.command;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ToAnyPageCommand extends AbstractCommand {
    public ToAnyPageCommand(CommandService service) {
        super(service);
    }

    public ToAnyPageCommand() {
    }

    @Override
    public Router execute(HttpServletRequest request) {
        HashMap<String,Object> attributeMap = new HashMap<>();

        getService().process(null,attributeMap);

        return (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
    }
}

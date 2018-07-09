package com.epam.creatures.command;

import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCommand {
    private CommandService service;


    public AbstractCommand(CommandService service) {
        this.service = service;
    }

    public AbstractCommand() {
    }

    public CommandService getService() {
        return service;
    }

    public void setService(CommandService service) {
        this.service = service;
    }

    public abstract Router execute(HttpServletRequest request);
}

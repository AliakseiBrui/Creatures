package com.epam.creatures.command;

import com.epam.creatures.entity.Router;
import com.epam.creatures.service.CommandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    public abstract Router execute(HttpServletRequest request)
            throws ServletException, IOException;
}

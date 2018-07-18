package com.epam.creatures.command;

import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCommand {
    private ProjectService service;


    public AbstractCommand(ProjectService service) {
        this.service = service;
    }

    public AbstractCommand() {
    }

    public ProjectService getService() {
        return service;
    }

    public void setService(ProjectService service) {
        this.service = service;
    }

    public abstract Router execute(HttpServletRequest request);
}

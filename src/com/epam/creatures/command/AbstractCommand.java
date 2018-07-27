package com.epam.creatures.command;

import com.epam.creatures.entity.Router;
import com.epam.creatures.service.ProjectService;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Abstract command.
 */
public abstract class AbstractCommand {
    private ProjectService service;


    /**
     * Instantiates a new Abstract command.
     *
     * @param service the service
     */
    public AbstractCommand(ProjectService service) {
        this.service = service;
    }

    /**
     * Instantiates a new Abstract command.
     */
    public AbstractCommand() {
    }

    /**
     * Gets service.
     *
     * @return the service
     */
    public ProjectService getService() {
        return service;
    }

    /**
     * Sets service.
     *
     * @param service the service
     */
    public void setService(ProjectService service) {
        this.service = service;
    }

    /**
     * Execute router.
     *
     * @param request the request
     * @return the router
     */
    public abstract Router execute(HttpServletRequest request);
}

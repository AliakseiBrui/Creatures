package com.epam.creatures.factory;

import com.epam.creatures.entity.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Router factory.
 */
public class RouterFactory {
    private static final Logger LOGGER = LogManager.getLogger(RouterFactory.class);

    /**
     * Create router router.
     *
     * @param routeType the route type
     * @param route     the route
     * @return the router
     */
    public Router createRouter(Router.RouteType routeType, String route){
        Router router = new Router(routeType,route);
        LOGGER.debug("Creating router. "+router);
        return router;
    }
}

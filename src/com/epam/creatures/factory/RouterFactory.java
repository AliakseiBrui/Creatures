package com.epam.creatures.factory;

import com.epam.creatures.entity.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RouterFactory {
    private static final Logger LOGGER = LogManager.getLogger(RouterFactory.class);

    public Router createRouter(Router.RouteType routeType, String route){
        Router router = new Router(routeType,route);
        LOGGER.debug("Creating router. "+router);
        return router;
    }
}

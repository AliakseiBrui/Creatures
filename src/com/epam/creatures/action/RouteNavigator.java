package com.epam.creatures.action;

import com.epam.creatures.entity.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RouteNavigator {
    public void send(Router router, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (router.getRouteType() == Router.RouteType.FORWARD) {
            request.getRequestDispatcher(router.getRoute()).forward(request, response);

        } else if (router.getRouteType() == Router.RouteType.REDIRECT) {
            response.sendRedirect(router.getRoute());
        }
    }
}

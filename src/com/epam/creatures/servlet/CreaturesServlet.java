package com.epam.creatures.servlet;

import com.epam.creatures.action.RouteNavigator;
import com.epam.creatures.command.CommandType;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.Router;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Creatures servlet.
 */
@WebServlet(name = "CreaturesServlet",
            urlPatterns = "/creatures")

public class CreaturesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = CommandType.valueOf(request.getParameter(ParameterConstant.COMMAND_TYPE_PARAMETER))
                .getCommand().execute(request);
        RouteNavigator routeNavigator = new RouteNavigator();
        routeNavigator.send(router,request,response);
    }
}

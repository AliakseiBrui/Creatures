package com.epam.creatures.filter;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.entity.ClientRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(dispatcherTypes = {
        DispatcherType.ASYNC,
        DispatcherType.ERROR,
        DispatcherType.FORWARD,
        DispatcherType.INCLUDE,
        DispatcherType.REQUEST
}
        ,urlPatterns = "/jsp/user/*",
        filterName = "UserUrlFilter")
public class UserUrlFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(UserUrlFilter.class);
    private static final String START_PAGE_RELATIVE_PATH = "../../index.jsp";
    private static final String ADMIN_MAIN_PAGE_RELATIVE_PATH = "../admin/admin_main.jsp";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ClientRole role = (ClientRole) request.getSession().getAttribute(AttributeConstant.ROLE_ATTRIBUTE);


        if(role==null){
            request.getRequestDispatcher(START_PAGE_RELATIVE_PATH).forward(request,response);
            LOGGER.debug("UserUrlFilter has worked.");
            return;
        }else if(role == ClientRole.ADMIN){
            request.getRequestDispatcher(ADMIN_MAIN_PAGE_RELATIVE_PATH).forward(request,response);
            LOGGER.debug("UserUrlFilter has worked.");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

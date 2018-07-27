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

/**
 * The type Admin page filter.
 */
@WebFilter(dispatcherTypes = {
        DispatcherType.ASYNC,
        DispatcherType.ERROR,
        DispatcherType.FORWARD,
        DispatcherType.INCLUDE,
        DispatcherType.REQUEST
}
,urlPatterns = "/jsp/admin/*"
,filterName = "AdminPageFilter")
public class AdminPageFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(AdminPageFilter.class);
    private static final String START_PAGE_RELATIVE_PATH = "../../index.jsp";
    private static final String USER_MAIN_PAGE_RELATIVE_PATH = "../user/user_main.jsp";
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
            LOGGER.debug("AdminPageFilter has worked.");
            return;

        }else if(role == ClientRole.USER){
            request.getRequestDispatcher(USER_MAIN_PAGE_RELATIVE_PATH).forward(request,response);
            LOGGER.debug("AdminPageFilter has worked.");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

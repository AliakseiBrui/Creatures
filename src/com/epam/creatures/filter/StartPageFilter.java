package com.epam.creatures.filter;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.entity.ClientRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * The type Start page filter.
 */
@WebFilter(urlPatterns = {
        "/index.jsp"
}
, filterName = "StartPageFilter")
public class StartPageFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(StartPageFilter.class);
    private static final String USER_PAGE_RELATIVE_PATH = "/jsp/user/user_main.jsp";
    private static final String ADMIN_PAGE_RELATIVE_PATH = "jsp/admin/admin_main.jsp";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ClientRole role = (ClientRole) request.getSession().getAttribute(AttributeConstant.ROLE_ATTRIBUTE);

        if (role == ClientRole.USER) {
            LOGGER.debug("StartPageFilter has worked.");
            request.getRequestDispatcher(USER_PAGE_RELATIVE_PATH).forward(servletRequest, servletResponse);
            return;

        } else if (role == ClientRole.ADMIN) {
            LOGGER.debug("StartPageFilter has worked.");
            request.getRequestDispatcher(ADMIN_PAGE_RELATIVE_PATH).forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package com.epam.creatures.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@WebFilter(urlPatterns = "/jsp/parts/*", filterName = "PartsUrlFilter")
public class PartsUrlFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(PartsUrlFilter.class);
    private static final String START_PAGE_RELATIVE_PATH = "../../index.jsp";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.getRequestDispatcher(START_PAGE_RELATIVE_PATH).forward(servletRequest,servletResponse);
        LOGGER.debug("PartsUrlFilter has worked.");
    }

    @Override
    public void destroy() {

    }
}

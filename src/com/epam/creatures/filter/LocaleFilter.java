package com.epam.creatures.filter;

import com.epam.creatures.command.CommandType;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Locale filter.
 */
@WebFilter(filterName = "LocaleFilter",servletNames = "CreaturesServlet")
public class LocaleFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(LocaleFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        CommandType commandType = CommandType.valueOf(request.getParameter(ParameterConstant.COMMAND_TYPE_PARAMETER));

        if(commandType == CommandType.CHANGE_LANGUAGE_COMMAND) {
            LOGGER.debug("LocaleFilter has worked.");
            request.getSession().setAttribute(AttributeConstant.LOCALE_ATTRIBUTE,request.getParameter(ParameterConstant.LOCALE_PARAMETER));
            response.sendRedirect(PagePath.START_PAGE);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

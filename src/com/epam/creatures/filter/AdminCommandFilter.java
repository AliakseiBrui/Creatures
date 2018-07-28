package com.epam.creatures.filter;

import com.epam.creatures.command.CommandType;
import com.epam.creatures.command.admin.AdminCommand;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.entity.ClientRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * The type Admin command filter.
 */
@WebFilter(filterName = "AdminFilter",servletNames = "CreaturesServlet")
public class AdminCommandFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(AdminCommandFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        CommandType commandType = CommandType.valueOf(request.getParameter(ParameterConstant.COMMAND_TYPE_PARAMETER));
        ClientRole role = (ClientRole) request.getSession().getAttribute(AttributeConstant.ROLE_ATTRIBUTE);

        if(!(commandType.getCommand() instanceof AdminCommand) && role!=ClientRole.ADMIN) {
            LOGGER.debug("AdminCommandFilter has worked.");
            response.sendRedirect(PagePath.START_PAGE);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

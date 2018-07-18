package com.epam.creatures.servlet;

import com.epam.creatures.config.DatabaseConfigurator;
import com.epam.creatures.constant.FilePath;
import com.epam.creatures.pool.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DatabaseConfigurator.INSTANCE.configureDBProperties(servletContextEvent
                .getServletContext()
                .getRealPath(File.separator + FilePath.CONFIG_DIRECTORY + File.separator + FilePath.DB_CONFIG_FILE));
        ConnectionPool.INSTANCE.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ConnectionPool.INSTANCE.closeAll();
    }
}

package com.epam.creatures.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Sql driver manager.
 */
class SqlDriverManager {
    private static final Logger LOGGER = LogManager.getLogger(SqlDriverManager.class);

    /**
     * Instantiates a new Sql driver manager.
     */
    SqlDriverManager(){}

    /**
     * Register driver.
     */
    void registerDriver(){
        LOGGER.debug("Registering sql drivers.");

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            LOGGER.fatal("Exception in sql driver registration.",e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Deregister drivers.
     */
    void deregisterDrivers(){
        DriverManager.drivers().forEach((this::deregisterDriver));
    }

    private void deregisterDriver(java.sql.Driver driver){
        LOGGER.debug("Deregistering sql driver.");

        try {
            DriverManager.deregisterDriver(driver);
        } catch (SQLException e) {
            LOGGER.fatal("Exception in sql driver deregistration.",e);
            throw new RuntimeException(e);
        }
    }
}

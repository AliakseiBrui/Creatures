package com.epam.creatures.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;

class SqlDriverManager {
    private static final Logger LOGGER = LogManager.getLogger(SqlDriverManager.class);

    SqlDriverManager(){}

    void registerDriver(){
        LOGGER.debug("Registering sql drivers.");

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            LOGGER.fatal("Exception in sql driver registration.",e);
            throw new RuntimeException(e);
        }
    }

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

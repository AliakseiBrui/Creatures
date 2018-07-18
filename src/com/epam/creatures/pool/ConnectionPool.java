package com.epam.creatures.pool;

import com.epam.creatures.config.DatabaseConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;

public enum ConnectionPool {
    INSTANCE;

    private static final String DB_URL_PROPERTY = "url";
    private static final int DEFAULT_POOL_SIZE = 10;
    private final LinkedBlockingQueue<SafeConnection> connectionQueue = new LinkedBlockingQueue<>();
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private boolean canInitialize = true;

    public SafeConnection takeConnection(){

        try{
            return connectionQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public void returnConnection(SafeConnection connection){

        try {
            connectionQueue.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void init(){
        SqlDriverManager sqlDriverManager = new SqlDriverManager();

        if(canInitialize) {
            LOGGER.debug("Initializing connection pool.");
            sqlDriverManager.registerDriver();

            try {

                for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
                    connectionQueue.put(createConnection(DatabaseConfigurator.INSTANCE.getDbProperties()));
                }
            } catch (InterruptedException e) {
                LOGGER.error("Interrupted while creating connections for connection pool.", e);
                Thread.currentThread().interrupt();
            }
            canInitialize = false;
        }
    }

    public void closeAll(){
        SqlDriverManager sqlDriverManager = new SqlDriverManager();

        for(int i=0; i<DEFAULT_POOL_SIZE; i++){

            try {
                connectionQueue.take().closeConnection();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        sqlDriverManager.deregisterDrivers();
    }



    private SafeConnection createConnection(Properties dbProperties){
        LOGGER.debug("Creating connection.");

        try {
            return new SafeConnection(DriverManager.getConnection((String) dbProperties.get(DB_URL_PROPERTY),dbProperties));
        } catch (SQLException e) {
            LOGGER.fatal("Exception while creating connection.",e);
            throw new RuntimeException(e);
        }
    }
}

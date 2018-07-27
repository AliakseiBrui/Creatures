package com.epam.creatures.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * The enum Database configurator.
 */
public enum DatabaseConfigurator {
    /**
     * Instance database configurator.
     */
    INSTANCE;

    private Properties dbProperties = null;
    private static final Logger LOGGER = LogManager.getLogger(DatabaseConfigurator.class);

    /**
     * Configure db properties.
     *
     * @param filePath the file path
     */
    public void configureDBProperties(String filePath){

        try(FileInputStream inputStream = new FileInputStream(new File(filePath))){
            dbProperties = new Properties();
            dbProperties.load(inputStream);
        } catch (FileNotFoundException e) {
            LOGGER.fatal("Database config file was not found.",e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            LOGGER.fatal("IOException while loading database properties file.",e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Get db properties properties.
     *
     * @return the properties
     */
    public Properties getDbProperties(){
        return dbProperties;
    }
}

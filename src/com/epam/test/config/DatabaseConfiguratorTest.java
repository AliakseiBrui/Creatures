package com.epam.test.config;

import com.epam.creatures.config.DatabaseConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

/**
 * The type Database configurator test.
 */
public class DatabaseConfiguratorTest {
    private static final Logger LOGGER = LogManager.getLogger(DatabaseConfiguratorTest.class);

    /**
     * Test config.
     */
    @Test
    public void testConfig(){

        DatabaseConfigurator.INSTANCE.configureDBProperties("web/config/db_config.properties");

        Properties properties = DatabaseConfigurator.INSTANCE.getDbProperties();

        Assert.assertNotNull(properties);

        LOGGER.info("url: ("+properties.get("url")+")");
        LOGGER.info("user: ("+properties.get("user")+")");
        LOGGER.info("password: ("+properties.get("password")+")");
        LOGGER.info("autoReconnect: ("+properties.get("autoReconnect")+")");
        LOGGER.info("characterEncoding: ("+properties.get("characterEncoding")+")");
        LOGGER.info("useUnicode: ("+properties.get("useUnicode")+")");
        LOGGER.info("useSSL: ("+properties.get("useSSL")+")");
    }
}

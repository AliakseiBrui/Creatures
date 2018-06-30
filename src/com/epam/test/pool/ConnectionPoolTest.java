package com.epam.test.pool;

import com.epam.creatures.config.DataBaseConfigurator;
import com.epam.creatures.pool.ConnectionPool;
import com.epam.creatures.pool.SafeConnection;
import org.testng.annotations.Test;

public class ConnectionPoolTest {

    @Test
    public void testConnectionPool(){
        DataBaseConfigurator.INSTANCE.configureDBProperties("web/config/db_config.properties");
        ConnectionPool.INSTANCE.init();

        SafeConnection connection = ConnectionPool.INSTANCE.takeConnection();
        System.out.println(connection);
        ConnectionPool.INSTANCE.returnConnection(connection);

        ConnectionPool.INSTANCE.closeAll();
    }
}

package com.epam.creatures.factory;

import com.epam.creatures.entity.Admin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdminFactory {
    private static final Logger LOGGER = LogManager.getLogger(AdminFactory.class);

    public Admin createAdmin(Integer id, String login, String password){
        LOGGER.debug("Creating admin.");
        return new Admin(id,login,password);
    }

    public Admin createAdmin(String login, String password){
        LOGGER.debug("Creating admin.");
        return new Admin(login,password);
    }
}

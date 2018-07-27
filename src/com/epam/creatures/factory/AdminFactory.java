package com.epam.creatures.factory;

import com.epam.creatures.entity.Admin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Admin factory.
 */
public class AdminFactory {
    private static final Logger LOGGER = LogManager.getLogger(AdminFactory.class);

    /**
     * Create admin admin.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     * @return the admin
     */
    public Admin createAdmin(Integer id, String login, String password){
        LOGGER.debug("Creating admin.");
        return new Admin(id,login,password);
    }

    /**
     * Create admin admin.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     * @param avatar   the avatar
     * @return the admin
     */
    public Admin createAdmin(Integer id, String login, String password, byte[] avatar){
        LOGGER.debug("Creating admin.");
        return new Admin(id,login,password,avatar);
    }

    /**
     * Create admin admin.
     *
     * @param login    the login
     * @param password the password
     * @return the admin
     */
    public Admin createAdmin(String login, String password){
        LOGGER.debug("Creating admin.");
        return new Admin(login,password);
    }

    /**
     * Create admin admin.
     *
     * @return the admin
     */
    public Admin createAdmin(){
        return new Admin();
    }
}

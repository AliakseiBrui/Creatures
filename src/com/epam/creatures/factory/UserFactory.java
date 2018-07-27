package com.epam.creatures.factory;

import com.epam.creatures.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type User factory.
 */
public class UserFactory {
    private static final Logger LOGGER = LogManager.getLogger(AdminFactory.class);

    /**
     * Create user user.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     * @param status   the status
     * @param isBanned the is banned
     * @return the user
     */
    public User createUser(Integer id,String login, String password, Double status, Boolean isBanned){
        LOGGER.debug("Creating user.");
        return new User(id,login,password,status,isBanned);
    }

    /**
     * Create user user.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     * @param status   the status
     * @param isBanned the is banned
     * @param avatar   the avatar
     * @return the user
     */
    public User createUser(Integer id,String login, String password, Double status, Boolean isBanned, byte[] avatar){
        LOGGER.debug("Creating user.");
        return new User(id,login,password,status,isBanned,avatar);
    }

    /**
     * Create user user.
     *
     * @param login    the login
     * @param password the password
     * @param status   the status
     * @param isBanned the is banned
     * @return the user
     */
    public User createUser(String login, String password, Double status, Boolean isBanned){
        LOGGER.debug("Creating user.");
        return new User(login,password,status,isBanned);
    }

    /**
     * Create user user.
     *
     * @param login    the login
     * @param password the password
     * @return the user
     */
    public User createUser(String login,String password) {
        LOGGER.debug("Creating user.");
        return new User(login,password);
    }

    /**
     * Create user user.
     *
     * @param id     the id
     * @param login  the login
     * @param avatar the avatar
     * @return the user
     */
    public User createUser(Integer id,String login,byte[] avatar) {
        LOGGER.debug("Creating user.");
        return new User(id,login,avatar);
    }

    /**
     * Create user user.
     *
     * @return the user
     */
    public User createUser(){
        LOGGER.debug("Creating user.");
        return new User();
    }

    /**
     * Create user user.
     *
     * @param id     the id
     * @param banned the banned
     * @return the user
     */
    public User createUser(int id, boolean banned){
        LOGGER.debug("Creating user.");
        return new User(id,banned);
    }

    /**
     * Create user user.
     *
     * @param id the id
     * @return the user
     */
    public User createUser(int id){
        LOGGER.debug("Creating user.");
        return new User(id);
    }
}

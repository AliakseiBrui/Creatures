package com.epam.creatures.factory;

import com.epam.creatures.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserFactory {
    private static final Logger LOGGER = LogManager.getLogger(AdminFactory.class);

    public User createUser(Integer id,String login, String password, Double status, Boolean isBanned){
        LOGGER.debug("Creating user.");
        return new User(id,login,password,status,isBanned);
    }

    public User createUser(Integer id,String login, String password, Double status, Boolean isBanned, byte[] avatar){
        LOGGER.debug("Creating user.");
        return new User(id,login,password,status,isBanned,avatar);
    }

    public User createUser(String login, String password, Double status, Boolean isBanned){
        LOGGER.debug("Creating user.");
        return new User(login,password,status,isBanned);
    }

    public User createUser(String login,String password) {
        LOGGER.debug("Creating user.");
        return new User(login,password);
    }

    public User createUser(){
        LOGGER.debug("Creating user.");
        return new User();
    }

    public User createUser(int id, boolean banned){
        LOGGER.debug("Creating user.");
        return new User(id,banned);
    }
}

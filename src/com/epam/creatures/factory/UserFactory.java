package com.epam.creatures.factory;

import com.epam.creatures.entity.User;

public class UserFactory {

    public User createUser(Integer id,String login, String password, Double status, Boolean isBanned){
        return new User(id,login,password,status,isBanned);
    }

    public User createUser(String login, String password, Double status, Boolean isBanned){
        return new User(login,password,status,isBanned);
    }
}

package com.epam.creatures.factory;

import com.epam.creatures.entity.Admin;

public class AdminFactory {

    public Admin createAdmin(Integer id, String login, String password){

        return new Admin(id,login,password);
    }

    public Admin createAdmin(String login, String password){

        return new Admin(login,password);
    }
}

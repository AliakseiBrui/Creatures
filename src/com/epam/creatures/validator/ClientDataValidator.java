package com.epam.creatures.validator;

public class ClientDataValidator {
    private static final Integer LOGIN_MAX_LENGTH = 10;
    private static final String RIGHT_LOGIN_DATA = "[\\w_]+";

    public boolean validateLogin(String login){

        return login.length()<=LOGIN_MAX_LENGTH
                && login.matches(RIGHT_LOGIN_DATA);
    }
}

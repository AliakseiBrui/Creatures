package com.epam.creatures.validator;

public class DataValidator {
    private static final Integer LOGIN_MAX_LENGTH = 40;
    private static final String LOGIN_PATTERN = ".+";

    public boolean validateLogin(String login){

        return login.length()<=LOGIN_MAX_LENGTH
                && login.matches(LOGIN_PATTERN);
    }
}

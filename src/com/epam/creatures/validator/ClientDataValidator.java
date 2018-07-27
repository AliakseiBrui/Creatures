package com.epam.creatures.validator;

/**
 * The type Client data validator.
 */
public class ClientDataValidator {
    private static final Integer LOGIN_MAX_LENGTH = 10;
    private static final String RIGHT_LOGIN_DATA = "[\\w_]+";

    /**
     * Validate login boolean.
     *
     * @param login the login
     * @return the boolean
     */
    public boolean validateLogin(String login){

        return login.length()<=LOGIN_MAX_LENGTH
                && login.matches(RIGHT_LOGIN_DATA);
    }
}

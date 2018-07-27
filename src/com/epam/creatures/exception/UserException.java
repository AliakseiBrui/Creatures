package com.epam.creatures.exception;

/**
 * The type User exception.
 */
public class UserException extends Exception {
    /**
     * Instantiates a new User exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public UserException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Instantiates a new User exception.
     *
     * @param message the message
     */
    public UserException(String message){
        super(message);
    }
}

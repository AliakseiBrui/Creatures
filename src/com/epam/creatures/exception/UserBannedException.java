package com.epam.creatures.exception;

public class UserBannedException extends Exception {
    public UserBannedException(String message, Throwable cause){
        super(message,cause);
    }

    public UserBannedException(String message){
        super(message);
    }
}

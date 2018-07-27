package com.epam.creatures.dao;

import java.sql.SQLException;

/**
 * The type Dao exception.
 */
public class DaoException extends SQLException {

    /**
     * Instantiates a new Dao exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public DaoException(String message, Throwable cause){
        super(message,cause);
    }

    /**
     * Instantiates a new Dao exception.
     *
     * @param cause the cause
     */
    public DaoException(Throwable cause){
        super(cause);
    }
}

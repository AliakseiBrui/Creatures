package com.epam.creatures.dao;

import java.sql.SQLException;

public class DaoException extends SQLException {

    public DaoException(String message, Throwable cause){
        super(message,cause);
    }

    public DaoException(Throwable cause){
        super(cause);
    }
}

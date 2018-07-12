package com.epam.creatures.dao;

import java.sql.SQLException;

public class DAOException extends SQLException {

    public DAOException(String message, Throwable cause){
        super(message,cause);
    }

    public DAOException(Throwable cause){
        super(cause);
    }
}

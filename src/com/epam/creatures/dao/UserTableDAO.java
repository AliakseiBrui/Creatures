package com.epam.creatures.dao;

import com.epam.creatures.entity.User;

public interface UserTableDAO {

    User findUserByLogin(String login) throws DAOException;
}

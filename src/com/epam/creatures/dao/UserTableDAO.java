package com.epam.creatures.dao;

import com.epam.creatures.entity.User;

import java.io.InputStream;

public interface UserTableDAO {

    User findUserByLogin(String login) throws DAOException;

    boolean updateUserBan(User user) throws DAOException;

    boolean updateUserStatus(Integer id, Double status) throws DAOException;

    boolean updateUserAvatar(Integer id, InputStream avatar) throws DAOException;
}

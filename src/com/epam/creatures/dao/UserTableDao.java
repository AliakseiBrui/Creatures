package com.epam.creatures.dao;

import com.epam.creatures.entity.User;

import java.io.InputStream;

public interface UserTableDao {

    User findUserByLogin(String login) throws DaoException;

    boolean updateUserBan(User user) throws DaoException;

    boolean updateUserStatus(Integer id, Double status) throws DaoException;

    boolean updateUserAvatar(Integer id, InputStream avatar) throws DaoException;
}

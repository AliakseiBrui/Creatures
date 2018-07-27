package com.epam.creatures.dao;

import com.epam.creatures.entity.User;

import java.io.InputStream;

/**
 * The interface User table dao.
 */
public interface UserTableDao {

    /**
     * Find user by login user.
     *
     * @param login the login
     * @return the user
     * @throws DaoException the dao exception
     */
    User findUserByLogin(String login) throws DaoException;

    /**
     * Update user ban boolean.
     *
     * @param user the user
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateUserBan(User user) throws DaoException;

    /**
     * Update user status boolean.
     *
     * @param id     the id
     * @param status the status
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateUserStatus(Integer id, Double status) throws DaoException;

    /**
     * Update user avatar boolean.
     *
     * @param id     the id
     * @param avatar the avatar
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateUserAvatar(Integer id, InputStream avatar) throws DaoException;
}

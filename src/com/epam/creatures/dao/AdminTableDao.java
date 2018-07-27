package com.epam.creatures.dao;

import com.epam.creatures.entity.Admin;

import java.io.InputStream;

/**
 * The interface Admin table dao.
 */
public interface AdminTableDao {

    /**
     * Find admin by login admin.
     *
     * @param login the login
     * @return the admin
     * @throws DaoException the dao exception
     */
    Admin findAdminByLogin(String login) throws DaoException;

    /**
     * Update admin avatar boolean.
     *
     * @param id     the id
     * @param avatar the avatar
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateAdminAvatar(Integer id, InputStream avatar) throws DaoException;
}

package com.epam.creatures.dao;

import com.epam.creatures.entity.Admin;

import java.io.InputStream;

public interface AdminTableDao {

    Admin findAdminByLogin(String login) throws DaoException;

    boolean updateAdminAvatar(Integer id, InputStream avatar) throws DaoException;
}

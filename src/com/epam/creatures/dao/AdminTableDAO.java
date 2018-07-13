package com.epam.creatures.dao;

import com.epam.creatures.entity.Admin;

import java.io.InputStream;

public interface AdminTableDAO {

    Admin findAdminByLogin(String login) throws DAOException;

    boolean updateAdminAvatar(Integer id, InputStream avatar) throws DAOException;
}

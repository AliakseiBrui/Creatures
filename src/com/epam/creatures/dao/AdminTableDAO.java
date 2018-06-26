package com.epam.creatures.dao;

import com.epam.creatures.entity.Admin;

public interface AdminTableDAO {

    Admin findAdminByLogin(String login) throws DAOException;
}

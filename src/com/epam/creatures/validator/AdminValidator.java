package com.epam.creatures.validator;

import com.epam.creatures.dao.impl.AdminDao;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.entity.Admin;

/**
 * The type Admin validator.
 */
public class AdminValidator {

    /**
     * Validate admin boolean.
     *
     * @param admin the admin
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public boolean validateAdmin(Admin admin) throws DaoException {
        AdminDao adminDAO = new AdminDao();
        if(admin!=null) {
            Admin currentAdmin = adminDAO.findAdminByLogin(admin.getLogin());

            if (currentAdmin != null && currentAdmin.getPassword().equals(admin.getPassword())) {
                admin.setId(currentAdmin.getId());
                admin.setAvatar(currentAdmin.getAvatar());
                return true;
            }
        }
        return false;
    }
}

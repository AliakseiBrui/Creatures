package com.epam.creatures.validator;

import com.epam.creatures.dao.AdminDAO;
import com.epam.creatures.dao.DAOException;
import com.epam.creatures.entity.Admin;

public class AdminValidator {

    public boolean validateAdminLogin(Admin admin) throws DAOException {
        AdminDAO adminDAO = new AdminDAO();
        Admin currentAdmin = adminDAO.findAdminByLogin(admin.getLogin());

        if(currentAdmin!=null && currentAdmin.getPassword().equals(admin.getPassword())){
            admin.setId(currentAdmin.getId());
            return true;
        }
        return false;
    }
}

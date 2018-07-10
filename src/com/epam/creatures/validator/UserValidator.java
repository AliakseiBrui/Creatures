package com.epam.creatures.validator;

import com.epam.creatures.dao.DAOException;
import com.epam.creatures.dao.UserDAO;
import com.epam.creatures.entity.User;
import com.epam.creatures.exception.UserBannedException;

public class UserValidator {

    public boolean validateUser(User user) throws DAOException, UserBannedException {
        UserDAO userDAO = new UserDAO();

        User currentUser = userDAO.findUserByLogin(user.getLogin());

        if (currentUser.getBanned()){
            throw new UserBannedException("Banned user is trying to get access into account.");
        }

        if(currentUser.getPassword().equals(user.getPassword())){

            user.setBanned(currentUser.getBanned());
            user.setId(currentUser.getId());
            user.setStatus(currentUser.getStatus());
            return true;
        }
        return false;
    }
}

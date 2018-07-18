package com.epam.creatures.validator;

import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.entity.User;
import com.epam.creatures.exception.UserException;

public class UserValidator {

    public boolean validateUser(User user) throws DaoException, UserException {
        UserDao userDAO = new UserDao();

        if(user!=null) {
            User currentUser = userDAO.findUserByLogin(user.getLogin());

            if(currentUser!=null) {

                if (currentUser.getBanned()) {
                    throw new UserException("Banned user is trying to get access into account.");
                }

                if (currentUser.getPassword().equals(user.getPassword())) {

                    user.setBanned(currentUser.getBanned());
                    user.setId(currentUser.getId());
                    user.setStatus(currentUser.getStatus());
                    user.setAvatar(currentUser.getAvatar());
                    return true;
                }
            }
        }
        return false;
    }
}

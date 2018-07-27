package com.epam.creatures.validator;

import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.entity.User;
import com.epam.creatures.exception.UserException;

/**
 * The type User validator.
 */
public class UserValidator {

    /**
     * Validate user boolean.
     *
     * @param user the user
     * @return the boolean
     * @throws DaoException  the dao exception
     * @throws UserException the user exception
     */
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

package com.epam.creatures.action;

import com.epam.creatures.entity.User;

import java.util.Comparator;
import java.util.List;

/**
 * The type User list sorter.
 */
public class UserListSorter {

    /**
     * The enum User sort type.
     */
    public enum UserSortType{
        /**
         * By login user sort type.
         */
        BY_LOGIN,
        /**
         * By status user sort type.
         */
        BY_STATUS
    }

    /**
     * Sort user list.
     *
     * @param userList the user list
     * @param sortType the sort type
     */
    public void sortUserList(List<User> userList, UserSortType sortType){

        if (sortType == UserSortType.BY_LOGIN) {
            sortByLogin(userList);

        } else if (sortType == UserSortType.BY_STATUS) {
            sortByStatus(userList);
        }
    }

    private void sortByLogin(List<User> userList){

        userList.sort(Comparator.comparing(User::getLogin));
    }

    private void sortByStatus(List<User> userList){

        userList.sort(Comparator.comparing(User::getStatus).reversed().thenComparing(User::getLogin));
    }
}

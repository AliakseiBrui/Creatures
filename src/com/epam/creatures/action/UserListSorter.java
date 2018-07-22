package com.epam.creatures.action;

import com.epam.creatures.entity.User;

import java.util.Comparator;
import java.util.List;

public class UserListSorter {

    public enum UserSortType{
        BY_LOGIN,
        BY_STATUS
    }

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

        userList.sort(Comparator.comparing(User::getStatus).thenComparing(User::getLogin));
    }
}

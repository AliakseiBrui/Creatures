package com.epam.creatures.entity;

import java.util.Arrays;
import java.util.Objects;

public class Admin implements Entity {
    private Integer id;
    private String login;
    private String password;
    private byte[] avatar;

    public Admin() {
    }

    public Admin(Integer id, String login, String password, byte[] avatar) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.avatar = avatar;
    }

    public Admin(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) &&
                Objects.equals(login, admin.login) &&
                Objects.equals(password, admin.password) &&
                Arrays.equals(avatar, admin.avatar);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, login, password);
        result = 31 * result + Arrays.hashCode(avatar);
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", avatar=" + Arrays.toString(avatar) +
                '}';
    }
}

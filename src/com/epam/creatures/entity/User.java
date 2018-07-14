package com.epam.creatures.entity;

import java.util.Arrays;
import java.util.Objects;

public class User implements Entity {
    private Integer id=null;
    private String login=null;
    private String password =null;
    private Double status = null;
    private Boolean isBanned = null;
    private byte[] avatar = null;
    private String encodedAvatar = null;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String login, byte[] avatar) {
        this.id = id;
        this.login = login;
        this.avatar = avatar;
    }

    public User(Integer id, Boolean isBanned) {
        this.id = id;
        this.isBanned = isBanned;
    }

    public User(Integer id, String login, String password, Double status, Boolean isBanned) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
        this.isBanned = isBanned;
    }

    public User(Integer id, String login, String password, Double status, Boolean isBanned, byte[] avatar) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
        this.isBanned = isBanned;
        this.avatar = avatar;
    }

    public User(String login, String password, Double status, Boolean isBanned) {
        this.login = login;
        this.password = password;
        this.status = status;
        this.isBanned = isBanned;
    }

    public User(String login, String password) {
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

    public Double getStatus() {
        return status;
    }

    public void setStatus(Double status) {
        this.status = status;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getEncodedAvatar() {
        return encodedAvatar;
    }

    public void setEncodedAvatar(String encodedAvatar) {
        this.encodedAvatar = encodedAvatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(status, user.status) &&
                Objects.equals(isBanned, user.isBanned) &&
                Arrays.equals(avatar, user.avatar);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, login, password, status, isBanned);
        result = 31 * result + Arrays.hashCode(avatar);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", isBanned=" + isBanned +
                ", avatar=" + Arrays.toString(avatar) +
                '}';
    }
}

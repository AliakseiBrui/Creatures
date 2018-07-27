package com.epam.creatures.entity;

import java.util.Arrays;
import java.util.Objects;

/**
 * The type Admin.
 */
public class Admin implements Entity {
    private Integer id;
    private String login;
    private String password;
    private byte[] avatar;

    /**
     * Instantiates a new Admin.
     */
    public Admin() {
    }

    /**
     * Instantiates a new Admin.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     * @param avatar   the avatar
     */
    public Admin(Integer id, String login, String password, byte[] avatar) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.avatar = avatar;
    }

    /**
     * Instantiates a new Admin.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     */
    public Admin(Integer id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    /**
     * Instantiates a new Admin.
     *
     * @param login    the login
     * @param password the password
     */
    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get avatar byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getAvatar() {
        return avatar;
    }

    /**
     * Sets avatar.
     *
     * @param avatar the avatar
     */
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

package com.epam.creatures.entity;

import java.util.Arrays;
import java.util.Objects;

/**
 * The type User.
 */
public class User implements Entity {
    private Integer id=null;
    private String login=null;
    private String password =null;
    private Double status = null;
    private Boolean isBanned = null;
    private byte[] avatar = null;
    private String encodedAvatar = null;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param id the id
     */
    public User(Integer id) {
        this.id = id;
    }

    /**
     * Instantiates a new User.
     *
     * @param id     the id
     * @param login  the login
     * @param avatar the avatar
     */
    public User(Integer id, String login, byte[] avatar) {
        this.id = id;
        this.login = login;
        this.avatar = avatar;
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param isBanned the is banned
     */
    public User(Integer id, Boolean isBanned) {
        this.id = id;
        this.isBanned = isBanned;
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     * @param status   the status
     * @param isBanned the is banned
     */
    public User(Integer id, String login, String password, Double status, Boolean isBanned) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
        this.isBanned = isBanned;
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     * @param status   the status
     * @param isBanned the is banned
     * @param avatar   the avatar
     */
    public User(Integer id, String login, String password, Double status, Boolean isBanned, byte[] avatar) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
        this.isBanned = isBanned;
        this.avatar = avatar;
    }

    /**
     * Instantiates a new User.
     *
     * @param login    the login
     * @param password the password
     * @param status   the status
     * @param isBanned the is banned
     */
    public User(String login, String password, Double status, Boolean isBanned) {
        this.login = login;
        this.password = password;
        this.status = status;
        this.isBanned = isBanned;
    }

    /**
     * Instantiates a new User.
     *
     * @param login    the login
     * @param password the password
     */
    public User(String login, String password) {
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
     * Gets status.
     *
     * @return the status
     */
    public Double getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Double status) {
        this.status = status;
    }

    /**
     * Gets banned.
     *
     * @return the banned
     */
    public Boolean getBanned() {
        return isBanned;
    }

    /**
     * Sets banned.
     *
     * @param banned the banned
     */
    public void setBanned(Boolean banned) {
        isBanned = banned;
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

    /**
     * Gets encoded avatar.
     *
     * @return the encoded avatar
     */
    public String getEncodedAvatar() {
        return encodedAvatar;
    }

    /**
     * Sets encoded avatar.
     *
     * @param encodedAvatar the encoded avatar
     */
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

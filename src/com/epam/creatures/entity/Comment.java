package com.epam.creatures.entity;

import java.util.Objects;

/**
 * The type Comment.
 */
public class Comment implements Entity{
    private Integer id;
    private String content;
    private Integer creatureId;
    private User user;

    /**
     * Instantiates a new Comment.
     *
     * @param id         the id
     * @param content    the content
     * @param creatureId the creature id
     * @param user       the user
     */
    public Comment(Integer id, String content, Integer creatureId, User user) {
        this.id = id;
        this.content = content;
        this.creatureId = creatureId;
        this.user = user;
    }

    /**
     * Instantiates a new Comment.
     *
     * @param content    the content
     * @param creatureId the creature id
     * @param user       the user
     */
    public Comment(String content, Integer creatureId, User user) {
        this.content = content;
        this.creatureId = creatureId;
        this.user = user;
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
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets creature id.
     *
     * @return the creature id
     */
    public Integer getCreatureId() {
        return creatureId;
    }

    /**
     * Sets creature id.
     *
     * @param creatureId the creature id
     */
    public void setCreatureId(Integer creatureId) {
        this.creatureId = creatureId;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(creatureId, comment.creatureId) &&
                Objects.equals(user, comment.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, creatureId, user);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creatureId=" + creatureId +
                ", user=" + user +
                '}';
    }
}

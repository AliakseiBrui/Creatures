package com.epam.creatures.entity;

import java.util.Objects;

public class Comment implements Entity{
    private Integer id;
    private String content;
    private Integer creatureId;
    private User user;

    public Comment(Integer id, String content, Integer creatureId, User user) {
        this.id = id;
        this.content = content;
        this.creatureId = creatureId;
        this.user = user;
    }

    public Comment(String content, Integer creatureId, User user) {
        this.content = content;
        this.creatureId = creatureId;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCreatureId() {
        return creatureId;
    }

    public void setCreatureId(Integer creatureId) {
        this.creatureId = creatureId;
    }

    public User getUser() {
        return user;
    }

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

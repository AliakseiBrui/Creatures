package com.epam.creatures.entity;

import java.util.Objects;

public class Comment implements Entity{
    private Integer id;
    private String content;
    private Integer creatureId;
    private Integer userId;

    public Comment(Integer id, String content, Integer creatureId, Integer userId) {
        this.id = id;
        this.content = content;
        this.creatureId = creatureId;
        this.userId = userId;
    }

    public Comment(String content, Integer creatureId, Integer userId) {
        this.content = content;
        this.creatureId = creatureId;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(creatureId, comment.creatureId) &&
                Objects.equals(userId, comment.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, content, creatureId, userId);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", creatureId=" + creatureId +
                ", userId=" + userId +
                '}';
    }
}

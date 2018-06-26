package com.epam.creatures.entity;

import java.util.Objects;

public class Mark implements Entity {
    private Double markValue;
    private Integer creatureId;
    private Integer userId;

    public Mark(Double markValue, Integer creatureId, Integer userId) {
        this.markValue = markValue;
        this.creatureId = creatureId;
        this.userId = userId;
    }

    public Double getMarkValue() {
        return markValue;
    }

    public void setMarkValue(Double markValue) {
        this.markValue = markValue;
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
        Mark mark = (Mark) o;
        return Objects.equals(markValue, mark.markValue) &&
                Objects.equals(creatureId, mark.creatureId) &&
                Objects.equals(userId, mark.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(markValue, creatureId, userId);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markValue=" + markValue +
                ", creatureId=" + creatureId +
                ", userId=" + userId +
                '}';
    }
}

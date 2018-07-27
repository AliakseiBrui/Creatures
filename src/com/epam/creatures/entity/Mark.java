package com.epam.creatures.entity;

import java.util.Objects;

/**
 * The type Mark.
 */
public class Mark implements Entity {
    private Double markValue;
    private Integer creatureId;
    private Integer userId;
    private Double statusComponent;

    /**
     * Instantiates a new Mark.
     *
     * @param markValue       the mark value
     * @param creatureId      the creature id
     * @param userId          the user id
     * @param statusComponent the status component
     */
    public Mark(Double markValue, Integer creatureId, Integer userId, Double statusComponent) {
        this.markValue = markValue;
        this.creatureId = creatureId;
        this.userId = userId;
        this.statusComponent = statusComponent;
    }

    /**
     * Instantiates a new Mark.
     *
     * @param markValue  the mark value
     * @param creatureId the creature id
     * @param userId     the user id
     */
    public Mark(Double markValue, Integer creatureId, Integer userId) {
        this.markValue = markValue;
        this.creatureId = creatureId;
        this.userId = userId;
    }

    /**
     * Gets mark value.
     *
     * @return the mark value
     */
    public Double getMarkValue() {
        return markValue;
    }

    /**
     * Sets mark value.
     *
     * @param markValue the mark value
     */
    public void setMarkValue(Double markValue) {
        this.markValue = markValue;
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
     * Gets user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets status component.
     *
     * @return the status component
     */
    public Double getStatusComponent() {
        return statusComponent;
    }

    /**
     * Sets status component.
     *
     * @param statusComponent the status component
     */
    public void setStatusComponent(Double statusComponent) {
        this.statusComponent = statusComponent;
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

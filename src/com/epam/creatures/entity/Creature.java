package com.epam.creatures.entity;

import java.util.Arrays;
import java.util.Objects;

/**
 * The type Creature.
 */
public class Creature implements Entity {

    /**
     * The enum Gender.
     */
    public enum Gender{
        /**
         * Male gender.
         */
        MALE, /**
         * Female gender.
         */
        FEMALE, /**
         * None gender.
         */
        NONE
    }

    private Integer creatureId;
    private String creatureName;
    private int limbQuantity;
    private int headQuantity;
    private int eyeQuantity;
    private Gender creatureGender;
    private String description;
    private Double creatureRating;
    private Integer creatorId;
    private String creatorName;
    private byte[] image;
    private String encodedImage;
    private boolean marked=false;

    /**
     * Instantiates a new Creature.
     *
     * @param creatureId     the creature id
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param description    the description
     * @param creatureRating the creature rating
     * @param creatorId      the creator id
     * @param creatorName    the creator name
     * @param image          the image
     */
    public Creature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity,
                    int eyeQuantity, Gender creatureGender, String description, Double creatureRating,
                    Integer creatorId, String creatorName, byte[] image) {
        this.creatureId = creatureId;
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.description = description;
        this.creatureRating = creatureRating;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.image = image;
    }

    /**
     * Instantiates a new Creature.
     *
     * @param creatureId     the creature id
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param description    the description
     * @param creatureRating the creature rating
     * @param creatorName    the creator name
     * @param image          the image
     */
    public Creature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                    Gender creatureGender, String description, Double creatureRating, String creatorName, byte[] image) {
        this.creatureId = creatureId;
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.description = description;
        this.creatureRating = creatureRating;
        this.creatorName = creatorName;
        this.image = image;
    }

    /**
     * Instantiates a new Creature.
     *
     * @param creatureId     the creature id
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param description    the description
     * @param creatureRating the creature rating
     * @param creatorId      the creator id
     * @param image          the image
     */
    public Creature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                    Gender creatureGender, String description, Double creatureRating, Integer creatorId, byte[] image) {
        this.creatureId = creatureId;
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.description = description;
        this.creatureRating = creatureRating;
        this.creatorId = creatorId;
        this.image = image;
    }

    /**
     * Instantiates a new Creature.
     *
     * @param creatureId     the creature id
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param description    the description
     * @param creatureRating the creature rating
     * @param creatorId      the creator id
     */
    public Creature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                    Gender creatureGender, String description, Double creatureRating, Integer creatorId) {

        this.creatureId = creatureId;
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.description = description;
        this.creatureRating = creatureRating;
        this.creatorId = creatorId;
    }

    /**
     * Instantiates a new Creature.
     *
     * @param creatureId     the creature id
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param creatorId      the creator id
     */
    public Creature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity, Gender creatureGender, Integer creatorId){
        this.creatureId = creatureId;
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.creatorId = creatorId;
    }

    /**
     * Instantiates a new Creature.
     *
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param description    the description
     * @param creatorId      the creator id
     */
    public Creature(String creatureName, int limbQuantity, int headQuantity, int eyeQuantity, Gender creatureGender, String description, Integer creatorId) {
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.description = description;
        this.creatorId = creatorId;
    }

    /**
     * Instantiates a new Creature.
     *
     * @param creatureId     the creature id
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param description    the description
     */
    public Creature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity, Gender creatureGender, String description) {
        this.creatureId = creatureId;
        this.creatureName = creatureName;
        this.limbQuantity = limbQuantity;
        this.headQuantity = headQuantity;
        this.eyeQuantity = eyeQuantity;
        this.creatureGender = creatureGender;
        this.description = description;
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
     * Gets creature name.
     *
     * @return the creature name
     */
    public String getCreatureName() {
        return creatureName;
    }

    /**
     * Sets creature name.
     *
     * @param creatureName the creature name
     */
    public void setCreatureName(String creatureName) {
        this.creatureName = creatureName;
    }

    /**
     * Gets limb quantity.
     *
     * @return the limb quantity
     */
    public int getLimbQuantity() {
        return limbQuantity;
    }

    /**
     * Sets limb quantity.
     *
     * @param limbQuantity the limb quantity
     */
    public void setLimbQuantity(int limbQuantity) {
        this.limbQuantity = limbQuantity;
    }

    /**
     * Gets eye quantity.
     *
     * @return the eye quantity
     */
    public int getEyeQuantity() {
        return eyeQuantity;
    }

    /**
     * Sets eye quantity.
     *
     * @param eyeQuantity the eye quantity
     */
    public void setEyeQuantity(int eyeQuantity) {
        this.eyeQuantity = eyeQuantity;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets head quantity.
     *
     * @return the head quantity
     */
    public int getHeadQuantity() {
        return headQuantity;
    }

    /**
     * Sets head quantity.
     *
     * @param headQuantity the head quantity
     */
    public void setHeadQuantity(int headQuantity) {
        this.headQuantity = headQuantity;
    }

    /**
     * Gets creature gender.
     *
     * @return the creature gender
     */
    public Gender getCreatureGender() {
        return creatureGender;
    }

    /**
     * Sets creature gender.
     *
     * @param creatureGender the creature gender
     */
    public void setCreatureGender(Gender creatureGender) {
        this.creatureGender = creatureGender;
    }

    /**
     * Gets creature rating.
     *
     * @return the creature rating
     */
    public Double getCreatureRating() {
        return creatureRating;
    }

    /**
     * Sets creature rating.
     *
     * @param creatureRating the creature rating
     */
    public void setCreatureRating(Double creatureRating) {
        this.creatureRating = creatureRating;
    }

    /**
     * Gets creator id.
     *
     * @return the creator id
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * Sets creator id.
     *
     * @param creatorId the creator id
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * Is marked boolean.
     *
     * @return the boolean
     */
    public boolean isMarked() {
        return marked;
    }

    /**
     * Sets marked.
     *
     * @param marked the marked
     */
    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    /**
     * Get image byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * Gets encoded image.
     *
     * @return the encoded image
     */
    public String getEncodedImage() {
        return encodedImage;
    }

    /**
     * Sets encoded image.
     *
     * @param encodedImage the encoded image
     */
    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    /**
     * Gets creator name.
     *
     * @return the creator name
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * Sets creator name.
     *
     * @param creatorName the creator name
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return limbQuantity == creature.limbQuantity &&
                headQuantity == creature.headQuantity &&
                eyeQuantity == creature.eyeQuantity &&
                marked == creature.marked &&
                Objects.equals(creatureId, creature.creatureId) &&
                Objects.equals(creatureName, creature.creatureName) &&
                creatureGender == creature.creatureGender &&
                Objects.equals(description, creature.description) &&
                Objects.equals(creatureRating, creature.creatureRating) &&
                Objects.equals(creatorId, creature.creatorId) &&
                Objects.equals(creatorName, creature.creatorName) &&
                Arrays.equals(image, creature.image) &&
                Objects.equals(encodedImage, creature.encodedImage);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(creatureId, creatureName, limbQuantity, headQuantity, eyeQuantity, creatureGender, description, creatureRating, creatorId, creatorName, encodedImage, marked);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "creatureId=" + creatureId +
                ", creatureName='" + creatureName + '\'' +
                ", limbQuantity=" + limbQuantity +
                ", headQuantity=" + headQuantity +
                ", eyeQuantity=" + eyeQuantity +
                ", creatureGender=" + creatureGender +
                ", description='" + description + '\'' +
                ", creatureRating=" + creatureRating +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", image=" + Arrays.toString(image) +
                ", encodedImage='" + encodedImage + '\'' +
                ", marked=" + marked +
                '}';
    }
}

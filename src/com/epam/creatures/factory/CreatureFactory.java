package com.epam.creatures.factory;

import com.epam.creatures.entity.Creature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Creature factory.
 */
public class CreatureFactory {
    private static final Logger LOGGER = LogManager.getLogger(CreatureFactory.class);

    /**
     * Create creature creature.
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
     * @return the creature
     */
    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Double creatureRating, Integer creatorId){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description,creatureRating, creatorId);
    }

    /**
     * Create creature creature.
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
     * @return the creature
     */
    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Double creatureRating, Integer creatorId,byte[] image){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description,creatureRating, creatorId, image);
    }

    /**
     * Create creature creature.
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
     * @return the creature
     */
    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Double creatureRating, Integer creatorId,String creatorName,byte[] image){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description,creatureRating, creatorId,creatorName, image);
    }

    /**
     * Create creature creature.
     *
     * @param creatureId     the creature id
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param creatorId      the creator id
     * @return the creature
     */
    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, Integer creatorId){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender, creatorId);
    }

    /**
     * Create creature creature.
     *
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param description    the description
     * @param creatorId      the creator id
     * @return the creature
     */
    public Creature createCreature(String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Integer creatorId){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description, creatorId);
    }

    /**
     * Create creature creature.
     *
     * @param creatureId     the creature id
     * @param creatureName   the creature name
     * @param limbQuantity   the limb quantity
     * @param headQuantity   the head quantity
     * @param eyeQuantity    the eye quantity
     * @param creatureGender the creature gender
     * @param description    the description
     * @return the creature
     */
    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity, Creature.Gender creatureGender, String description){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description);
    }
}

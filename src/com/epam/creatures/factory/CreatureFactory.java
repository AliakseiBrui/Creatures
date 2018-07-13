package com.epam.creatures.factory;

import com.epam.creatures.entity.Creature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatureFactory {
    private static final Logger LOGGER = LogManager.getLogger(CreatureFactory.class);

    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Double creatureRating, Integer creatorId){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description,creatureRating, creatorId);
    }

    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Double creatureRating, Integer creatorId,byte[] image){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description,creatureRating, creatorId, image);
    }

    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Double creatureRating, Integer creatorId,String creatorName,byte[] image){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description,creatureRating, creatorId,creatorName, image);
    }

    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, Integer creatorId){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender, creatorId);
    }

    public Creature createCreature(String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Integer creatorId){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description, creatorId);
    }

    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity, Creature.Gender creatureGender, String description){
        LOGGER.debug("Creating creature.");
        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description);
    }
}

package com.epam.creatures.factory;

import com.epam.creatures.entity.Creature;

public class CreatureFactory {

    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, String description, Double creatureRating, Integer creatorId){

        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender,description,creatureRating, creatorId);
    }

    public Creature createCreature(Integer creatureId, String creatureName, int limbQuantity, int headQuantity, int eyeQuantity,
                                   Creature.Gender creatureGender, Integer creatorId){

        return new Creature(creatureId,creatureName,limbQuantity,headQuantity,eyeQuantity,creatureGender, creatorId);
    }
}

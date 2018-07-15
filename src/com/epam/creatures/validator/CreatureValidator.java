package com.epam.creatures.validator;

import com.epam.creatures.entity.Creature;

public class CreatureValidator {
    private static final Integer NAME_MAX_LENGTH = 40;
    private static final String RIGHT_NAME_DATA = ".+";
    private static final Integer DESCRIPTION_MAX_LENGTH = 200;
    private static final String RIGHT_DESCRIPTION_DATA = ".+";
    private static final Integer MIN_LIMBS = 0;
    private static final Integer MAX_LIMBS = 100;
    private static final Integer MIN_HEADS = 0;
    private static final Integer MAX_HEADS = 100;
    private static final Integer MIN_EYES = 0;
    private static final Integer MAX_EYES = 100;


    public boolean validateCreature(Creature creature){

        if(creature.getDescription()!=null && creature.getDescription().length() <= DESCRIPTION_MAX_LENGTH
                && creature.getDescription().matches(RIGHT_DESCRIPTION_DATA)){
            return false;
        }
        return creature.getCreatureName()!=null && creature.getCreatureGender()!=null
                && creature.getCreatureName().length() < NAME_MAX_LENGTH
                && creature.getCreatureName().matches(RIGHT_NAME_DATA)
                && creature.getLimbQuantity() >= MIN_LIMBS && creature.getLimbQuantity() <= MAX_LIMBS
                && creature.getHeadQuantity() >= MIN_HEADS && creature.getHeadQuantity() <= MAX_HEADS
                && creature.getEyeQuantity() >= MIN_EYES && creature.getEyeQuantity() <= MAX_EYES;
    }
}

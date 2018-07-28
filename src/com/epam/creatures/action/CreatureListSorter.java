package com.epam.creatures.action;

import com.epam.creatures.entity.Creature;

import java.util.Comparator;
import java.util.List;

/**
 * The type Creature list sorter.
 */
public class CreatureListSorter {

    /**
     * The enum Creature sort type.
     */
    public enum CreatureSortType{
        /**
         * By name creature sort type.
         */
        BY_NAME,
        /**
         * By rating creature sort type.
         */
        BY_RATING,
        /**
         * By limbs creature sort type.
         */
        BY_LIMBS,
        /**
         * By heads creature sort type.
         */
        BY_HEADS,
        /**
         * By eyes creature sort type.
         */
        BY_EYES
    }

    /**
     * Sort creature list.
     *
     * @param creatureList the creature list
     * @param sortType     the sort type
     */
    public void sortCreatureList(List<Creature> creatureList, CreatureSortType sortType){

        switch (sortType){
            case BY_NAME:
                sortByName(creatureList);
                break;

            case BY_RATING:
                sortByRating(creatureList);
                break;

            case BY_LIMBS:
                sortByLimbs(creatureList);
                break;

            case BY_HEADS:
                sortByHeads(creatureList);
                break;

            case BY_EYES:
                sortByEyes(creatureList);
                break;
        }
    }

    private void sortByName(List<Creature> creatureList){

        creatureList.sort(Comparator.comparing(Creature::getCreatureName));
    }

    private void sortByRating(List<Creature> creatureList){

        creatureList.sort(Comparator.comparing(Creature::getCreatureRating).reversed().thenComparing(Creature::getCreatureName));
    }

    private void sortByLimbs(List<Creature> creatureList){

        creatureList.sort(Comparator.comparing(Creature::getLimbQuantity).reversed().thenComparing(Creature::getCreatureName));
    }

    private void sortByHeads(List<Creature> creatureList){

        creatureList.sort(Comparator.comparing(Creature::getHeadQuantity).reversed().thenComparing(Creature::getCreatureName));
    }

    private void sortByEyes(List<Creature> creatureList){

        creatureList.sort(Comparator.comparing(Creature::getEyeQuantity).reversed().thenComparing(Creature::getCreatureName));
    }
}

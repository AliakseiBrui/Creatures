package com.epam.creatures.action;

import com.epam.creatures.entity.Creature;

import java.util.Comparator;
import java.util.List;

public class CreatureListSorter {

    public enum CreatureSortType{
        BY_NAME,
        BY_RATING,
        BY_LIMBS,
        BY_HEADS,
        BY_EYES
    }

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

        creatureList.sort(Comparator.comparing(Creature::getCreatureRating).thenComparing(Creature::getCreatureName));
    }

    private void sortByLimbs(List<Creature> creatureList){

        creatureList.sort(Comparator.comparing(Creature::getLimbQuantity).thenComparing(Creature::getCreatureName));
    }

    private void sortByHeads(List<Creature> creatureList){

        creatureList.sort(Comparator.comparing(Creature::getHeadQuantity).thenComparing(Creature::getCreatureName));
    }

    private void sortByEyes(List<Creature> creatureList){

        creatureList.sort(Comparator.comparing(Creature::getEyeQuantity).thenComparing(Creature::getCreatureName));
    }
}

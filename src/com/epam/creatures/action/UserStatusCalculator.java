package com.epam.creatures.action;

public class UserStatusCalculator {
    private static final Double DEFAULT_STATUS = 5.0;
    private static final Double MAX_RATING = 5.0;
    private static final Double NO_RATING = 0.0;

    public Double calculateStatus(Double markValue, Double creatureRating) {

        if(markValue==null || creatureRating == null || creatureRating.equals(NO_RATING)){
            return DEFAULT_STATUS;
        }
        return (MAX_RATING-Math.abs(creatureRating-markValue))*2;
    }
}

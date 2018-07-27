package com.epam.creatures.factory;

import com.epam.creatures.entity.Mark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Mark factory.
 */
public class MarkFactory {
    private static final Logger LOGGER = LogManager.getLogger(MarkFactory.class);

    /**
     * Create mark mark.
     *
     * @param markValue  the mark value
     * @param creatureId the creature id
     * @param userId     the user id
     * @return the mark
     */
    public Mark createMark(Double markValue, Integer creatureId, Integer userId){
        LOGGER.debug("Creating mark.");
        return new Mark(markValue,creatureId,userId);
    }

    /**
     * Create mark mark.
     *
     * @param markValue       the mark value
     * @param creatureId      the creature id
     * @param userId          the user id
     * @param statusComponent the status component
     * @return the mark
     */
    public Mark createMark(Double markValue, Integer creatureId, Integer userId, Double statusComponent){
        LOGGER.debug("Creating mark.");
        return new Mark(markValue,creatureId,userId,statusComponent);
    }
}

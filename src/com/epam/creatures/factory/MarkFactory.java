package com.epam.creatures.factory;

import com.epam.creatures.entity.Mark;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MarkFactory {
    private static final Logger LOGGER = LogManager.getLogger(MarkFactory.class);

    public Mark createMark(Double markValue, Integer creatureId, Integer userId){
        LOGGER.debug("Creating mark.");
        return new Mark(markValue,creatureId,userId);
    }

    public Mark createMark(Double markValue, Integer creatureId, Integer userId, Double statusComponent){
        LOGGER.debug("Creating mark.");
        return new Mark(markValue,creatureId,userId,statusComponent);
    }
}

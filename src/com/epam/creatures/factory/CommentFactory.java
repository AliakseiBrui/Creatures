package com.epam.creatures.factory;

import com.epam.creatures.entity.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommentFactory {
    private static final Logger LOGGER = LogManager.getLogger(CommentFactory.class);

    public Comment createComment(Integer id, String content, Integer creatureId, Integer userId){
        LOGGER.debug("Creating comment.");
        return new Comment(id, content, creatureId, userId);
    }

    public Comment createComment(String content, Integer creatureId, Integer userId){
        LOGGER.debug("Creating comment.");
        return new Comment(content,creatureId,userId);
    }
}

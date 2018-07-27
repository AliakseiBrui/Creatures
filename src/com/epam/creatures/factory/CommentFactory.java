package com.epam.creatures.factory;

import com.epam.creatures.entity.Comment;
import com.epam.creatures.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Comment factory.
 */
public class CommentFactory {
    private static final Logger LOGGER = LogManager.getLogger(CommentFactory.class);

    /**
     * Create comment comment.
     *
     * @param id         the id
     * @param content    the content
     * @param creatureId the creature id
     * @param user       the user
     * @return the comment
     */
    public Comment createComment(Integer id, String content, Integer creatureId, User user){
        LOGGER.debug("Creating comment.");
        return new Comment(id, content, creatureId, user);
    }

    /**
     * Create comment comment.
     *
     * @param content    the content
     * @param creatureId the creature id
     * @param user       the user
     * @return the comment
     */
    public Comment createComment(String content, Integer creatureId, User user){
        LOGGER.debug("Creating comment.");
        return new Comment(content,creatureId,user);
    }
}

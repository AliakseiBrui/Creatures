package com.epam.creatures.validator;

import com.epam.creatures.entity.Comment;

/**
 * The type Comment validator.
 */
public class CommentValidator {
    private static final Integer COMMENT_MAX_LENGTH = 200;
    private static final String RIGHT_COMMENT_DATA = "[\\w\\s]+";

    /**
     * Validate comment boolean.
     *
     * @param comment the comment
     * @return the boolean
     */
    public boolean validateComment(Comment comment) {
        return comment.getContent().length() <= COMMENT_MAX_LENGTH
                && comment.getContent().matches(RIGHT_COMMENT_DATA);
    }
}

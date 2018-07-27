package com.epam.creatures.dao;

import com.epam.creatures.entity.Comment;

import java.util.List;

/**
 * The interface Comment table dao.
 */
public interface CommentTableDao {
    /**
     * Find comments by creature id list.
     *
     * @param creatureId the creature id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Comment> findCommentsByCreatureId(Integer creatureId) throws DaoException;
}

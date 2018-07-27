package com.epam.creatures.dao;

import com.epam.creatures.entity.Mark;

import java.util.List;

/**
 * The interface Mark table dao.
 */
public interface MarkTableDao {
    /**
     * Find mark mark.
     *
     * @param creatureId the creature id
     * @param userId     the user id
     * @return the mark
     * @throws DaoException the dao exception
     */
    Mark findMark(Integer creatureId, Integer userId) throws DaoException;

    /**
     * Find marks list.
     *
     * @param userId the user id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Mark> findMarks(Integer userId) throws DaoException;
}

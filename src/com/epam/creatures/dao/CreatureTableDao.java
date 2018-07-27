package com.epam.creatures.dao;

import com.epam.creatures.entity.Creature;

import java.io.InputStream;
import java.util.List;

/**
 * The interface Creature table dao.
 */
public interface CreatureTableDao {
    /**
     * Find creature by name creature.
     *
     * @param name the name
     * @return the creature
     * @throws DaoException the dao exception
     */
    Creature findCreatureByName(String name) throws DaoException;

    /**
     * Find creatures by creator id list.
     *
     * @param creatorId the creator id
     * @return the list
     * @throws DaoException the dao exception
     */
    List<Creature> findCreaturesByCreatorId(Integer creatorId) throws DaoException;

    /**
     * Update creature image boolean.
     *
     * @param id    the id
     * @param image the image
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean updateCreatureImage(Integer id, InputStream image) throws DaoException;
}

package com.epam.creatures.dao;

import com.epam.creatures.entity.Entity;

import java.util.List;

/**
 * The type Abstract dao.
 *
 * @param <K> the type parameter
 * @param <T> the type parameter
 */
public abstract class AbstractDao<K,T extends Entity> {
    /**
     * Find all list.
     *
     * @return the list
     * @throws DaoException the dao exception
     */
    public abstract List<T> findAll() throws DaoException;

    /**
     * Find entity by id t.
     *
     * @param id the id
     * @return the t
     * @throws DaoException the dao exception
     */
    public abstract T findEntityById(K id) throws DaoException;

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean delete(K id) throws DaoException;

    /**
     * Create boolean.
     *
     * @param entity the entity
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean create(T entity) throws DaoException;

    /**
     * Update boolean.
     *
     * @param entity the entity
     * @return the boolean
     * @throws DaoException the dao exception
     */
    public abstract boolean update(T entity) throws DaoException;
}

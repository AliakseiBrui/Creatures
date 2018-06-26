package com.epam.creatures.dao;

import com.epam.creatures.entity.Entity;

import java.util.List;

public abstract class AbstractDAO<K,T extends Entity> {
    public abstract List<T> findAll() throws DAOException;
    public abstract T findEntityById(K id) throws DAOException;
    public abstract boolean delete(K id) throws DAOException;
    public abstract boolean delete(T entity) throws DAOException;
    public abstract boolean create(T entity) throws DAOException;
    public abstract boolean update(T entity) throws DAOException;
}

package com.epam.creatures.dao;

import com.epam.creatures.entity.Creature;

import java.io.InputStream;
import java.util.List;

public interface CreatureTableDao {
    Creature findCreatureByName(String name) throws DaoException;
    List<Creature> findCreaturesByCreatorId(Integer creatorId) throws DaoException;
    boolean updateCreatureImage(Integer id, InputStream image) throws DaoException;
}

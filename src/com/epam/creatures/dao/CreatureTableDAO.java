package com.epam.creatures.dao;

import com.epam.creatures.entity.Creature;

import java.util.List;

public interface CreatureTableDAO {
    Creature findCreatureByName(String name) throws DAOException;
    List<Creature> findCreaturesByCreatorId(Integer creatorId) throws DAOException;
}

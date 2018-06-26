package com.epam.creatures.dao;

import com.epam.creatures.entity.Creature;

public interface CreatureTableDAO {
    Creature findCreatureByName(String name) throws DAOException;
}

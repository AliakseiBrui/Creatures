package com.epam.creatures.dao;

import com.epam.creatures.entity.Mark;

public interface MarkTableDAO {
    Mark findMark(Integer creatureId, Integer userId) throws DAOException;
}

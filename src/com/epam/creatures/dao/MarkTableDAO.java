package com.epam.creatures.dao;

import com.epam.creatures.entity.Mark;

import java.util.List;

public interface MarkTableDAO {
    Mark findMark(Integer creatureId, Integer userId) throws DAOException;
    List<Mark> findMarks(Integer userId) throws DAOException;
}

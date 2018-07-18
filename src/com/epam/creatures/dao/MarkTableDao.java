package com.epam.creatures.dao;

import com.epam.creatures.entity.Mark;

import java.util.List;

public interface MarkTableDao {
    Mark findMark(Integer creatureId, Integer userId) throws DaoException;
    List<Mark> findMarks(Integer userId) throws DaoException;
}

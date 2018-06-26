package com.epam.creatures.dao;

import com.epam.creatures.entity.Comment;

import java.util.List;

public interface CommentTableDAO {
    List<Comment> findCommentsByCreatureId(Integer creatureId) throws DAOException;
}

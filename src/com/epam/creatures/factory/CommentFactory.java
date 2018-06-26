package com.epam.creatures.factory;

import com.epam.creatures.entity.Comment;

public class CommentFactory {

    public Comment createComment(Integer id, String content, Integer creatureId, Integer userId){

        return new Comment(id, content, creatureId, userId);
    }

    public Comment createComment(String content, Integer creatureId, Integer userId){

        return new Comment(content,creatureId,userId);
    }
}

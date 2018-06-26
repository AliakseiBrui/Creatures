package com.epam.creatures.factory;

import com.epam.creatures.entity.Mark;

public class MarkFactory {

    public Mark createMark(Double markValue, Integer creatureId, Integer userId){

        return new Mark(markValue,creatureId,userId);
    }
}

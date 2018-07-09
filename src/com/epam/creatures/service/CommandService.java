package com.epam.creatures.service;

import java.util.Map;

public interface CommandService {

    void process(Map<String,String> parameterMap, Map<String,Object> attributeMap);
}

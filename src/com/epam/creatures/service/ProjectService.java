package com.epam.creatures.service;

import java.util.Map;

/**
 * The interface Project service.
 */
public interface ProjectService {

    /**
     * Process.
     *
     * @param parameterMap the parameter map
     * @param attributeMap the attribute map
     */
    void process(Map<String,String> parameterMap, Map<String,Object> attributeMap);
}

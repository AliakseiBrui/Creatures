package com.epam.creatures.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Xss validator.
 */
public class XssValidator {
    private static final Pattern XSS_PATTERN = Pattern.compile("<.+>");

    /**
     * Check for xss attack boolean.
     *
     * @param data the data
     * @return the boolean
     */
    public boolean checkForXssAttack(String data){

        Matcher matcher = XSS_PATTERN.matcher(data);
        return !matcher.find();
    }
}

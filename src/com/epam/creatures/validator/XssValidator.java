package com.epam.creatures.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XssValidator {
    private static final Pattern XSS_PATTERN = Pattern.compile("<.+>");

    public boolean checkForXssAttack(String data){

        Matcher matcher = XSS_PATTERN.matcher(data);
        return !matcher.find();
    }
}

package com.epam.test.validator;

import com.epam.creatures.validator.XssValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The type Xss validator test.
 */
public class XssValidatorTest {
    private XssValidator xssValidator = new XssValidator();
    private static final String WRONG_DATA = "fsafew<rwqwr>faswhytjyt<rqwdsaf>";
    private static final String RIGHT_DATA = "abcdefg oprst";

    /**
     * Test check for xss attack 1.
     */
    @Test
    public void testCheckForXssAttack1(){

        Assert.assertFalse(xssValidator.checkForXssAttack(WRONG_DATA));
    }

    /**
     * Test check for xss attack 2.
     */
    @Test
    public void testCheckForXssAttack2(){

        Assert.assertTrue(xssValidator.checkForXssAttack(RIGHT_DATA));
    }
}

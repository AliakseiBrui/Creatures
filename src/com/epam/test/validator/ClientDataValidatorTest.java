package com.epam.test.validator;

import com.epam.creatures.validator.ClientDataValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * The type Client data validator test.
 */
public class ClientDataValidatorTest {
    private ClientDataValidator dataValidator = new ClientDataValidator();
    private static final String WRONG_LOGIN = "abc abc";
    private static final String RIGHT_LOGIN = "login";

    /**
     * Test validate login 1.
     */
    @Test
    public void testValidateLogin1(){

        Assert.assertTrue(dataValidator.validateLogin(RIGHT_LOGIN));
    }

    /**
     * Test validate login 2.
     */
    @Test
    public void testValidateLogin2(){

        Assert.assertFalse(dataValidator.validateLogin(WRONG_LOGIN));
    }
}

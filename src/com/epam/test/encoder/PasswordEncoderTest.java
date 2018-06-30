package com.epam.test.encoder;

import com.epam.creatures.encoder.PasswordEncoder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordEncoderTest {
    private static final String PASSWORD = "1234";
    private static final int HASH_SIZE = 64;
    private PasswordEncoder passwordEncoder = new PasswordEncoder();

    @Test
    public void encryptPassword1(){

        String encryptedPassword = passwordEncoder.encryptPassword(PASSWORD);

        Assert.assertNotNull(encryptedPassword);

        System.out.println(encryptedPassword);
    }

    @Test
    public void encryptPassword2(){
        String encryptedPassword = passwordEncoder.encryptPassword(PASSWORD);

        Assert.assertEquals(HASH_SIZE,encryptedPassword.length());

        System.out.println(encryptedPassword);
    }
}

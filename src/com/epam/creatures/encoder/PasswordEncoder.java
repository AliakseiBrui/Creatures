package com.epam.creatures.encoder;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Password encoder.
 */
public class PasswordEncoder {
    private static final Logger LOGGER = LogManager.getLogger(PasswordEncoder.class);

    /**
     * Encrypt password string.
     *
     * @param password the password
     * @return the string
     */
    public String encryptPassword(String password){
        LOGGER.debug("Encrypting password.");
        return DigestUtils.sha256Hex(password);
    }
}

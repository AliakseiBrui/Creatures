package com.epam.creatures.validator;

/**
 * The type Picture validator.
 */
public class PictureValidator {
    private static final Long AVATAR_MAX_SIZE = 2764L;
    private static final Long CREATURE_IMAGE_MAX_SIZE = 999999999999999999L;

    /**
     * Validate avatar size boolean.
     *
     * @param avatar the avatar
     * @return the boolean
     */
    public boolean validateAvatarSize(byte[] avatar){

        return avatar.length <= AVATAR_MAX_SIZE;
    }

    /**
     * Validate creature image size boolean.
     *
     * @param image the image
     * @return the boolean
     */
    public boolean validateCreatureImageSize(byte[] image){

        return image.length <= CREATURE_IMAGE_MAX_SIZE;
    }
}

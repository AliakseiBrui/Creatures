package com.epam.creatures.validator;

public class PictureValidator {
    private static final Long AVATAR_MAX_SIZE = 2764L;
    private static final Long CREATURE_IMAGE_MAX_SIZE = 999999999999999999L;

    public boolean validateAvatarSize(byte[] avatar){

        return avatar.length <= AVATAR_MAX_SIZE;
    }

    public boolean validateCreatureImageSize(byte[] image){

        return image.length <= CREATURE_IMAGE_MAX_SIZE;
    }
}

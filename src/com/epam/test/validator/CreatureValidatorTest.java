package com.epam.test.validator;

import com.epam.creatures.entity.Creature;
import com.epam.creatures.factory.CreatureFactory;
import com.epam.creatures.validator.CreatureValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The type Creature validator test.
 */
public class CreatureValidatorTest {
    private CreatureValidator creatureValidator = new CreatureValidator();
    private CreatureFactory creatureFactory = new CreatureFactory();
    private Creature wrongCreature;
    private Creature wrongCreature2;
    private Creature wrongCreature3;
    private Creature wrongCreature4;
    private Creature rightCreature;

    /**
     * Set up.
     */
    @BeforeClass
    public void setUp(){
        wrongCreature = creatureFactory.createCreature("abc43",200,100,100,Creature.Gender.MALE,null,null);
        wrongCreature2 = creatureFactory.createCreature("abc43",100,200,100,Creature.Gender.MALE,null,null);
        wrongCreature3 = creatureFactory.createCreature("abc43",100,100,200,Creature.Gender.MALE,null,null);
        wrongCreature4 = creatureFactory.createCreature("abc43*&",100,100,100,Creature.Gender.MALE,null,null);
        rightCreature = creatureFactory.createCreature("abc43",100,100,100,Creature.Gender.MALE,null,null);
    }

    /**
     * Test validate creature 1.
     */
    @Test
    public void testValidateCreature1(){

        Assert.assertTrue(creatureValidator.validateCreature(rightCreature));
    }

    /**
     * Test validate creature 2.
     */
    @Test
    public void testValidateCreature2(){

        Assert.assertFalse(creatureValidator.validateCreature(wrongCreature));
    }

    /**
     * Test validate creature 3.
     */
    @Test
    public void testValidateCreature3(){

        Assert.assertFalse(creatureValidator.validateCreature(wrongCreature2));
    }

    /**
     * Test validate creature 4.
     */
    @Test
    public void testValidateCreature4(){

        Assert.assertFalse(creatureValidator.validateCreature(wrongCreature3));
    }

    /**
     * Test validate creature 5.
     */
    @Test
    public void testValidateCreature5(){

        Assert.assertFalse(creatureValidator.validateCreature(wrongCreature4));
    }
}

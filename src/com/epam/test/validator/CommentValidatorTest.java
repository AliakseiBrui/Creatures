package com.epam.test.validator;

import com.epam.creatures.entity.Comment;
import com.epam.creatures.factory.CommentFactory;
import com.epam.creatures.validator.CommentValidator;
        import org.testng.Assert;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

public class CommentValidatorTest {
    private CommentFactory commentFactory = new CommentFactory();
    private CommentValidator commentValidator = new CommentValidator();
    private Comment wrongComment;
    private Comment wrongComment2;
    private Comment rightComment;
    private Comment rightComment2;

    @BeforeClass
    public void setUp(){
        wrongComment = commentFactory.createComment("abc$abc",null,null);
        wrongComment2 = commentFactory.createComment("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                ,null,null);
        rightComment = commentFactory.createComment("right comment",null,null);
        rightComment2 = commentFactory.createComment("RIGHT COMMENT",null,null);
    }

    @Test
    public void testValidateComment1(){

        Assert.assertTrue(commentValidator.validateComment(rightComment));
    }

    @Test
    public void testValidateComment2(){

        Assert.assertFalse(commentValidator.validateComment(wrongComment));
    }

    @Test
    public void testValidateComment3(){

        Assert.assertTrue(commentValidator.validateComment(rightComment2));
    }

    @Test
    public void testValidateComment4(){

        Assert.assertFalse(commentValidator.validateComment(wrongComment2));
    }


}

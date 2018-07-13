package com.epam.creatures.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class PictureTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger(PictureTag.class);
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    @Override
    public int doStartTag(){

        try{
            pageContext.getResponse().setContentType("image/jpg");
            if(picture!=null) {
                JspWriter jspWriter = pageContext.getOut();
                jspWriter.write(picture);
            }else{
                JspWriter writer = pageContext.getOut();
                writer.write("NO IMAGE");
            }
        } catch (IOException e) {
            LOGGER.error("Exception in tag UserInfoTag.");
        }finally {
            pageContext.getResponse().setContentType("text/html");
        }
        return SKIP_BODY;
    }

}

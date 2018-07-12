package com.epam.creatures.tag;

import com.epam.creatures.constant.AttributeConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
@SuppressWarnings("serial")
public class UserInfoTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger(UserInfoTag.class);
    private String loginLabel;

    public void setLoginLabel(String loginLabel) {
        this.loginLabel = loginLabel;
    }

    @Override
    public int doStartTag(){
        String login = "<b>"+loginLabel+": "+ pageContext.getSession().getAttribute(AttributeConstant.LOGIN_ATTRIBUTE) + "</b>";

        try{
            JspWriter writer = pageContext.getOut();
            writer.write(login);
        } catch (IOException e) {
            LOGGER.error("Exception in tag UserInfoTag.");
        }
        return SKIP_BODY;
    }
}

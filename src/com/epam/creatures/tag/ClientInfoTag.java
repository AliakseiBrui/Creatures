package com.epam.creatures.tag;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.entity.ClientRole;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

@SuppressWarnings("serial")
public class ClientInfoTag extends TagSupport {
    private String buttonProfile;
    private String buttonLogOut;

    public String getButtonProfile() {
        return buttonProfile;
    }

    public void setButtonProfile(String buttonProfile) {
        this.buttonProfile = buttonProfile;
    }

    public String getButtonLogOut() {
        return buttonLogOut;
    }

    public void setButtonLogOut(String buttonLogOut) {
        this.buttonLogOut = buttonLogOut;
    }

    @Override
    public int doStartTag() throws JspException{
        String login = (String) pageContext.getSession().getAttribute(AttributeConstant.LOGIN_ATTRIBUTE);
        ClientRole clientRole = (ClientRole) pageContext.getSession().getAttribute(AttributeConstant.ROLE_ATTRIBUTE);
        Double status = (Double) pageContext.getSession().getAttribute(AttributeConstant.STATUS_ATTRIBUTE);
        String avatar = (String) pageContext.getSession().getAttribute(AttributeConstant.AVATAR_ATTRIBUTE);
        String info = "";
        if(login!=null) {
            info =
                    "            <div class=\"user\">\n" +
                    "                    <div class=\"user-body\">\n" +
                    "                        <br/>\n" +
                    "                        <div class=\"user-avatar\" align=\"center\">\n" +
                    "                            <img class=\"user-avatar-img\" alt=\"NO AVATAR\" src=\"data:image/jpg;base64,"+avatar+"\">\n" +
                    "                        </div>\n" +
                    "                        <br/>\n" +
                    "                        <div class=\"user-role\">\n" +
                    "                            "+clientRole+"\n" +
                    "                        </div>\n" +
                    "                        <div class=\"user-name\">\n" +
                    "                            "+login+"\n" +
                    "                        </div>\n" +
                    "                    </div>\n";

            if(clientRole==ClientRole.USER){
                info+=
                        "                            <div class=\"user-footer\">\n"+
                        "                               <div class=\"user-status\">\n" +
                        "                                   "+status+"\n" +
                        "                               </div>\n"+
                        "                            </div>\n"+
                        "                            <div align=\"right\" class=\"user-button\">\n" +
                        "                                <form action=\"/creatures\" method=\"get\">\n" +
                        "                                    <input type=\"hidden\" name=\"commandType\" value=\"TO_USER_PROFILE_PAGE_COMMAND\"/>\n" +
                        "                                    <input type=\"submit\" value="+buttonProfile+" class=\"nice-button\"/>\n" +
                        "                                </form>\n" +
                        "                            </div>\n" +
                        "                    <div align=\"right\">\n" +
                        "                        <form action=\"/creatures\" method=\"get\" class=\"user-button\">\n" +
                        "                            <input type=\"hidden\" name=\"commandType\" value=\"LOG_OUT_COMMAND\"/>\n" +
                        "                            <input type=\"submit\" value="+buttonLogOut+" class=\"nice-button\"/>\n" +
                        "                        </form>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "                <br/>\n";
            }else if(clientRole==ClientRole.ADMIN){
                info+=
                        "                            <div class=\"user-footer\">\n"+
                        "                            </div>\n"+
                        "                            <div align=\"right\" class=\"user-button\">\n" +
                        "                                <form action=\"/creatures\" method=\"get\">\n" +
                        "                                    <input type=\"hidden\" name=\"commandType\" value=\"TO_ADMIN_PROFILE_PAGE_COMMAND\"/>\n" +
                        "                                    <input type=\"submit\" value="+buttonProfile+" class=\"nice-button\"/>\n" +
                        "                                </form>\n" +
                        "                            </div>\n" +
                        "                    <div align=\"right\">\n" +
                        "                        <form action=\"/creatures\" method=\"get\" class=\"user-button\">\n" +
                        "                            <input type=\"hidden\" name=\"commandType\" value=\"LOG_OUT_COMMAND\"/>\n" +
                        "                            <input type=\"submit\" value="+buttonLogOut+" class=\"nice-button\"/>\n" +
                        "                        </form>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "                <br/>\n";
            }
        }
        try{
            JspWriter writer = pageContext.getOut();
            writer.write(info);
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}

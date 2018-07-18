package com.epam.creatures.servlet;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.constant.PictureType;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.AdminDao;
import com.epam.creatures.dao.impl.CreaturesDao;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.validator.PictureValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Base64;

@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadingServlet extends HttpServlet {
    private static final String PICTURE = "picture";
    private static final Logger LOGGER = LogManager.getLogger(FileUploadingServlet.class);
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part picture = null;
        StringBuilder errorMessage = new StringBuilder();

        try{
            picture = request.getPart(PICTURE);
        }catch (Exception e){//////
            LOGGER.error(e);
            errorMessage.append(e).append(".");
        }

        if(picture!=null){
            PictureType pictureType = PictureType.valueOf(request.getParameter(ParameterConstant.PICTURE_TYPE_PARAMETER));
            PictureValidator pictureValidator = new PictureValidator();
            Integer id;

            try {

                switch (pictureType) {
                    case CREATURE_IMAGE:

                        if(pictureValidator.validateCreatureImageSize(picture.getInputStream().readAllBytes())) {
                            CreaturesDao creaturesDAO = new CreaturesDao();//service todo
                            id = Integer.parseInt(request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER));
                            creaturesDAO.updateCreatureImage(id, picture.getInputStream());
                            response.sendRedirect(PagePath.ADMIN_MAIN_PAGE);
                            return;
                        }
                        else{
                            errorMessage.append("Image size is too high.");
                        }
                        break;
                    case USER_AVATAR:

                        if(pictureValidator.validateAvatarSize(picture.getInputStream().readAllBytes())) {
                            UserDao userDAO = new UserDao();
                            id = Integer.parseInt(request.getParameter(ParameterConstant.USER_ID_PARAMETER));
                            userDAO.updateUserAvatar(id, picture.getInputStream());
                            request.getSession().setAttribute(AttributeConstant.AVATAR_ATTRIBUTE, Base64.getEncoder().encodeToString(picture.getInputStream().readAllBytes()));
                            response.sendRedirect(PagePath.USER_MAIN_PAGE);
                            return;
                        }else{
                            errorMessage.append("Avatar size is too high.");
                        }
                        break;
                    case ADMIN_AVATAR:

                        if(pictureValidator.validateAvatarSize(picture.getInputStream().readAllBytes())) {
                            AdminDao adminDAO = new AdminDao();
                            id = Integer.parseInt(request.getParameter(ParameterConstant.ADMIN_ID_PARAMETER));
                            adminDAO.updateAdminAvatar(id, picture.getInputStream());
                            request.getSession().setAttribute(AttributeConstant.AVATAR_ATTRIBUTE, Base64.getEncoder().encodeToString(picture.getInputStream().readAllBytes()));
                            response.sendRedirect(PagePath.ADMIN_MAIN_PAGE);
                            return;
                        }else{
                            errorMessage.append("Avatar size is too high.");
                        }
                        break;
                }
            }catch (DaoException e){
                LOGGER.error(e);
                errorMessage.append(e).append(".");
            }
        }else{
            errorMessage.append("No picture was found.");
        }
        request.setAttribute(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        request.getRequestDispatcher(PagePath.USER_MAIN_PAGE).forward(request,response);
    }
}
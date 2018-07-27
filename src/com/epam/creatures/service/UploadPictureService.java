package com.epam.creatures.service;

import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.PagePath;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.constant.PictureType;
import com.epam.creatures.dao.DaoException;
import com.epam.creatures.dao.impl.AdminDao;
import com.epam.creatures.dao.impl.CreaturesDao;
import com.epam.creatures.dao.impl.UserDao;
import com.epam.creatures.entity.Router;
import com.epam.creatures.factory.RouterFactory;
import com.epam.creatures.validator.PictureValidator;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

/**
 * The type Upload picture service.
 */
public class UploadPictureService implements ProjectService {
    @Override
    public void process(Map<String, String> parameterMap, Map<String, Object> attributeMap) {
        Part picture= (Part) attributeMap.get(AttributeConstant.PICTURE_ATTRIBUTE);
        RouterFactory routerFactory = new RouterFactory();
        StringBuilder errorMessage = new StringBuilder();
        String route = PagePath.USER_MAIN_PAGE;
        Router.RouteType routeType = Router.RouteType.FORWARD;
        if(picture!=null){
            PictureType pictureType = PictureType.valueOf(parameterMap.get(ParameterConstant.PICTURE_TYPE_PARAMETER));
            PictureValidator pictureValidator = new PictureValidator();
            Integer id;

            try {

                switch (pictureType) {
                    case CREATURE_IMAGE:

                        if(pictureValidator.validateCreatureImageSize(picture.getInputStream().readAllBytes())) {
                            CreaturesDao creaturesDAO = new CreaturesDao();
                            id = Integer.parseInt(parameterMap.get(ParameterConstant.CREATURE_ID_PARAMETER));
                            creaturesDAO.updateCreatureImage(id, picture.getInputStream());
                            route=PagePath.ADMIN_MAIN_PAGE;
                            routeType=Router.RouteType.REDIRECT;
                        }
                        else{
                            errorMessage.append("Image size is too high.");
                        }
                        break;
                    case USER_AVATAR:

                        if(pictureValidator.validateAvatarSize(picture.getInputStream().readAllBytes())) {
                            UserDao userDAO = new UserDao();
                            id = Integer.parseInt(parameterMap.get(ParameterConstant.USER_ID_PARAMETER));
                            userDAO.updateUserAvatar(id, picture.getInputStream());
                            attributeMap.put(AttributeConstant.AVATAR_ATTRIBUTE, Base64.getEncoder().encodeToString(picture.getInputStream().readAllBytes()));
                            route=PagePath.USER_MAIN_PAGE;
                            routeType=Router.RouteType.REDIRECT;
                        }else{
                            errorMessage.append("Avatar size is too high.");
                        }
                        break;
                    case ADMIN_AVATAR:

                        if(pictureValidator.validateAvatarSize(picture.getInputStream().readAllBytes())) {
                            AdminDao adminDAO = new AdminDao();
                            id = Integer.parseInt(parameterMap.get(ParameterConstant.ADMIN_ID_PARAMETER));
                            adminDAO.updateAdminAvatar(id, picture.getInputStream());
                            attributeMap.put(AttributeConstant.AVATAR_ATTRIBUTE, Base64.getEncoder().encodeToString(picture.getInputStream().readAllBytes()));
                            route=PagePath.ADMIN_MAIN_PAGE;
                            routeType=Router.RouteType.REDIRECT;
                        }else{
                            errorMessage.append("Avatar size is too high.");
                        }
                        break;
                }
            }catch (DaoException | IOException e){
                errorMessage.append(e.getLocalizedMessage()).append(".");
            }
        }else{
            errorMessage.append("No picture was found.");
        }
        attributeMap.put(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,errorMessage);
        attributeMap.put(AttributeConstant.ROUTER_ATTRIBUTE,routerFactory
                .createRouter(routeType,route));
    }
}

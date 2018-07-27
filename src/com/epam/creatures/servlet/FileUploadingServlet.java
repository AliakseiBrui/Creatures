package com.epam.creatures.servlet;

import com.epam.creatures.action.RouteNavigator;
import com.epam.creatures.constant.AttributeConstant;
import com.epam.creatures.constant.ParameterConstant;
import com.epam.creatures.constant.PictureType;
import com.epam.creatures.entity.Router;
import com.epam.creatures.service.UploadPictureService;
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
import java.util.HashMap;

/**
 * The type File uploading servlet.
 */
@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadingServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(FileUploadingServlet.class);
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part picture = null;

        try{
            picture = request.getPart(AttributeConstant.PICTURE_ATTRIBUTE);
        }catch (IOException | ServletException e) {
            LOGGER.error(e);
        }

        UploadPictureService service = new UploadPictureService();
        HashMap<String,String> parameterMap = new HashMap<>();
        HashMap<String,Object> attributeMap = new HashMap<>();

        parameterMap.put(ParameterConstant.PICTURE_TYPE_PARAMETER,request.getParameter(ParameterConstant.PICTURE_TYPE_PARAMETER));
        attributeMap.put(AttributeConstant.PICTURE_ATTRIBUTE,picture);
        parameterMap.put(ParameterConstant.CREATURE_ID_PARAMETER,request.getParameter(ParameterConstant.CREATURE_ID_PARAMETER));
        parameterMap.put(ParameterConstant.USER_ID_PARAMETER, request.getParameter(ParameterConstant.USER_ID_PARAMETER));
        parameterMap.put(ParameterConstant.ADMIN_ID_PARAMETER, request.getParameter(ParameterConstant.ADMIN_ID_PARAMETER));

        service.process(parameterMap,attributeMap);

        PictureType pictureType = PictureType.valueOf(parameterMap.get((ParameterConstant.PICTURE_TYPE_PARAMETER)));

        if(pictureType==PictureType.USER_AVATAR || pictureType == PictureType.ADMIN_AVATAR) {
            request.getSession().setAttribute(AttributeConstant.AVATAR_ATTRIBUTE, attributeMap.get(AttributeConstant.AVATAR_ATTRIBUTE));
        }
        request.setAttribute(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE,attributeMap.get(AttributeConstant.ERROR_MESSAGE_ATTRIBUTE));
        Router router = (Router) attributeMap.get(AttributeConstant.ROUTER_ATTRIBUTE);
        RouteNavigator routeNavigator = new RouteNavigator();
        routeNavigator.send(router,request,response);
    }
}
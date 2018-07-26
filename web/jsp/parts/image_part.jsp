<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13.07.2018
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<div align="right">
    <c:choose>
        <c:when test="${not empty creature.getEncodedImage()}">
            <img width="200" height="150" alt="NO IMAGE" src="data:image/jpg;base64,${creature.getEncodedImage()}"/>
        </c:when>
        <c:otherwise>
            <img width="200" height="150" alt="NO IMAGE" src="../../pics/no_image.png"/>
        </c:otherwise>
    </c:choose>
</div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Application</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<br/>
<div align="center">
    <c:forEach var="creature" items="${creatureList}">
        <div class="creature">
            <div class="creature-body">
                <div class="creature-img">
                    <%@ include file="../parts/image_part.jsp"%>
                </div>
                <div class="creature-name">
                    <c:out value="${creature.getCreatureName()}"/>
                </div>
                <div class="creature-creator">
                    Creator: <c:out value="${creature.getCreatorId()}"/>
                </div>
                <div class="creature-limbs">
                    Limbs: <c:out value="${creature.getLimbQuantity()}"/>
                </div>
                <div class="creature-heads">
                    Heads: <c:out value="${creature.getHeadQuantity()}"/>
                </div>
                <div class="creature-eyes">
                    Eyes: <c:out value="${creature.getEyeQuantity()}"/>
                </div>
                <div class="creature-gender">
                    Gender: <c:out value="${creature.getCreatureGender()}"/>
                </div>
                <div class="creature-desc">
                    <c:out value="${creature.getDescription()}"/>
                </div>
            </div>
            <div class="creature-footer">
                <div class="creature-mark">
                    <c:out value="${creature.getCreatureRating()}"/>
                </div>
                <div class="creature-button">
                    <form action="/creatures" method="post">
                        <input type="hidden" name="commandType" value="TO_UPDATE_CREATURE_PAGE_COMMAND"/>
                        <input type="hidden" name="creatureId" value="${creature.getCreatureId()}"/>
                        <input type="hidden" name="creatureName" value="${creature.getCreatureName()}"/>
                        <input type="hidden" name="creatureLimbQuantity" value="${creature.getLimbQuantity()}"/>
                        <input type="hidden" name="creatureHeadQuantity" value="${creature.getHeadQuantity()}"/>
                        <input type="hidden" name="creatureEyeQuantity" value="${creature.getEyeQuantity()}"/>
                        <input type="hidden" name="creatureGender" value="${creature.getCreatureGender()}"/>
                        <input type="hidden" name="creatureDescription" value="${creature.getDescription()}"/>
                        <input type="submit" value="Update" class="nice-button"/>
                    </form>
                </div>
                <div class="creature-button">
                    <form action="/creatures" method="post">
                        <input type="hidden" name="commandType" value="DELETE_CREATURE_COMMAND"/>
                        <input type="hidden" name="creatureId" value="${creature.getCreatureId()}"/>
                        <input type="submit" value="Delete" class="nice-button"/>
                    </form>
                </div>
                <div class="creature-button">
                    <form action="/creatures" method="post">
                        <input type="hidden" name="commandType" value="TO_CHANGE_CREATURE_IMAGE_PAGE_COMMAND"/>
                        <input type="hidden" name="creatureId" value="${creature.getCreatureId()}"/>
                        <input type="submit" value="Change image" class="nice-button"/>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
    <br/>
</div>
</body>
</html>

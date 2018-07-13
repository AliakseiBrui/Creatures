<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13.06.2018
  Time: 23:45
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
                    <c:choose>
                        <c:when test="${creature.isMarked() == true}">
                            <c:out value="${creature.getCreatureRating()}"/>
                        </c:when>
                        <c:otherwise>
                            <div align="right">
                                <form id="likeForm" action="/creatures" method="get">
                                    <input type="hidden" name="commandType" value="LIKE_CREATURE_COMMAND"/>
                                    <input type="hidden" name="creatureId" value="${creature.getCreatureId()}">
                                    <select name="mark" class="custom-select">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                    <br/><br/>
                                    <input type="submit" value="like" class="nice-button"/>
                                </form>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="creature-button">
                    <form id="creatureForm" action="/creatures" method="post">
                        <input type="hidden" name="commandType" value="TO_CREATURE_DETAILS_PAGE_COMMAND"/>
                        <input type="hidden" name="creatureId" value="${creature.getCreatureId()}"/>
                        <input type="submit" value="Details" class="nice-button"/>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
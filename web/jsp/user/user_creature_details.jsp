<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.07.2018
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creature details</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../parts/header.jsp"%>
<div align="left">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_USER_MAIN_PAGE_COMMAND"/>

        <input type="submit" value="Main Page" class="nice-button"/>
    </form>
</div>
<br/>
<div align="center">
    <div class="creature">
        <div class="creature-body">
            <div class="creature-img">
                    <img content="${creatureImage}"/>
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
        </div>
    </div>
    <br/>
    <div align="center">
        <form action="/creatures" method="get">
            <input type="hidden" name="commandType" value="TO_COMMENT_CREATURE_PAGE_COMMAND"/>
            <input type="hidden" name="creatureId" value="${creature.getCreatureId()}"/>

            <input type="submit" value="Comment creature" class="nice-button"/>
        </form>
    </div>
    <c:import url="/creatures?commandType=SHOW_CREATURE_COMMENTS_COMMAND&creatureId=${creature.getCreatureId()}"/>
</div>
</body>
</html>

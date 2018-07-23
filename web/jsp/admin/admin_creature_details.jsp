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
        <input type="hidden" name="commandType" value="TO_ADMIN_MAIN_PAGE_COMMAND"/>
        <input type="submit" name="to_main_page_button" value="Main Page" class="nice-button"/>
    </form>
</div>
<div align="center">
    <br/>
    <c:import url="/creatures?commandType=SHOW_CREATURE_COMMENTS_COMMAND"/>
    <br/>
    <div class="creature">
        <div class="creature-body">
            <div class="creature-img">
                <%@ include file="../parts/image_part.jsp"%>
            </div>
            <div class="creature-name">
                <c:out value="${creature.getCreatureName()}"/>
            </div>
            <div class="creature-creator">
                Created by <c:out value="${creature.getCreatorName()}"/>
            </div>
            <div class="creature-limbs">
                <c:out value="${creature.getLimbQuantity()}"/> Limb(s).
            </div>
            <div class="creature-heads">
                <c:out value="${creature.getHeadQuantity()}"/> Head(s).
            </div>
            <div class="creature-eyes">
                <c:out value="${creature.getEyeQuantity()}"/> Eye(s).
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
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>

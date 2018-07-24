<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.07.2018
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<html>
<head>
    <title><fmt:message key="title.user_creature_details"/></title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../parts/header.jsp"%>
<div align="left">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_USER_MAIN_PAGE_COMMAND"/>

        <input type="submit" value="<fmt:message key="button.main_page"/>" class="nice-button"/>
    </form>
</div>
<br/><br/>
<div>
    <div align="center">
        <c:import url="/creatures?commandType=SHOW_CREATURE_COMMENTS_COMMAND&creatureId=${creature.getCreatureId()}"/>
        <br/>
        <div align="center">
            <form action="/creatures" method="get">
                <input type="hidden" name="commandType" value="TO_COMMENT_CREATURE_PAGE_COMMAND"/>
                <input type="hidden" name="creatureId" value="${creature.getCreatureId()}"/>

                <input type="submit" value="<fmt:message key="button.comment_creature"/>" class="nice-button"/>
            </form>
        </div>
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
                    <fmt:message key="creature.created_by"/> <c:out value="${creature.getCreatorName()}"/>.
                </div>
                <div class="creature-limbs">
                    <fmt:message key="creature.limbs"/> <c:out value="${creature.getLimbQuantity()}"/>.
                </div>
                <div class="creature-heads">
                    <fmt:message key="creature.heads"/> <c:out value="${creature.getHeadQuantity()}"/>.
                </div>
                <div class="creature-eyes">
                    <fmt:message key="creature.eyes"/> <c:out value="${creature.getEyeQuantity()}"/>.
                </div>
                <div class="creature-gender">
                    <fmt:message key="creature.gender"/> <c:out value="${creature.getCreatureGender()}"/>.
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
    </div>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>
</fmt:bundle>
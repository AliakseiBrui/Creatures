<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01.07.2018
  Time: 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<html>
<head>
    <title><fmt:message key="title.user_main"/></title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../parts/header.jsp"%>
<br/>
<div align="left">
    <form id="sortForm" action="/creatures" method="get">
        <input type="hidden" name="commandType" value="CHANGE_CREATURE_SORT_TYPE_COMMAND"/>
        <select class="custom-select" name="sortCreature" oninput="document.getElementById('sortForm').submit()">
            <option hidden><fmt:message key="label.sort"/></option>
            <option value="BY_NAME"><fmt:message key="label.sort.creature.by_name"/></option>
            <option value="BY_RATING"><fmt:message key="label.sort.creature.by_rating"/></option>
            <option value="BY_LIMBS"><fmt:message key="label.sort.creature.by_limbs"/></option>
            <option value="BY_HEADS"><fmt:message key="label.sort.creature.by_heads"/></option>
            <option value="BY_EYES"><fmt:message key="label.sort.creature.by_eyes"/></option>
        </select>
    </form>
</div>
<br/>
<div>
    <c:import url="/creatures?commandType=SHOW_CREATURES_COMMAND"/>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>
</fmt:bundle>
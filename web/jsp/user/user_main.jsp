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

</head>
<body>
<%@ include file="../parts/header.jsp"%>
<br/>
<div>
    <c:import url="/creatures?commandType=SHOW_CREATURES_COMMAND"/>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>
</fmt:bundle>
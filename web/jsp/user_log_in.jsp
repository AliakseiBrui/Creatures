<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01.07.2018
  Time: 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<html>
<head>
    <title><fmt:message key="title.user_log_in"/></title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="parts/header.jsp"%>
<div align="left">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_START_PAGE_COMMAND"/>

        <input type="submit" value="<fmt:message key="button.start_page"/>" class="nice-button"/>
    </form>
</div>

<div align="center">
    <form action="/creatures" method="post">
        <input type="hidden" name="commandType" value="USER_AUTHORIZATION_COMMAND"/>

        <jsp:include page="parts/enter_user_data_part.jsp"/>

        <input type="submit" value="<fmt:message key="button.log_in"/>" class="nice-button"/>
    </form>
</div>
<%@ include file="parts/footer.jsp"%>
</body>
</html>
</fmt:bundle>
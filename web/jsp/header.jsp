<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01.07.2018
  Time: 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div>
        avatar,login
    </div>
    <div align="center">
        <c:choose>
            <c:when test="${not empty errorMessage}">
                <strong class="error-message">
                    <c:out value="${errorMessage}"/>
                </strong>
            </c:when>
            <c:otherwise>
                <strong class="succeed-message">
                    <c:out value="${message}"/>
                </strong>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>

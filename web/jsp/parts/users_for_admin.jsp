<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<html>
<head>
    <title>Application</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center">
    <div class="client-container">
        <c:forEach var="user" items="${userList}">
            <div class="client">
                <div class="client-body">
                    <div class="client-avatar">
                        <img class="client-avatar-img" alt="NO AVATAR" src="data:image/jpg;base64,${user.getEncodedAvatar()}">
                    </div>
                </div>
                <div class="client-login">
                    <c:out value="${user.getLogin()}"/>
                </div>
                <div class="client-banned">
                    <p>
                        <fmt:message key="user.banned"/> <c:out value="${user.getBanned()}"/>
                    </p>
                </div>
                <div class="client-footer">
                    <div class="client-status">
                        <c:out value="${user.getStatus()}"/>
                    </div>
                    <div class="client-button">
                        <form action="/creatures" method="get">
                            <input type="hidden" name="commandType" value="CHANGE_USER_BANNED_COMMAND"/>
                            <input type="hidden" name="userId" value="${user.getId()}"/>

                            <input type="submit" value="<fmt:message key="button.ban_unban"/>" class="nice-button"/>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <br/>
</div>
</body>
</html>
</fmt:bundle>
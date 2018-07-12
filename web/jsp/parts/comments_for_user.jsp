<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.07.2018
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<br/>
<div align="center">
    <c:forEach var="comment" items="${commentList}">
        <div class="comment">
            <div class="comment-body">
                <div class="comment-creator">
                    <c:out value="${comment.getUserId()}"/>
                </div>
                <div class="comment-content">
                    Creator: <c:out value="${comment.getContent()}"/>
                </div>
            </div>
            <div class="comment-footer">
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>

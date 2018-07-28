<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.07.2018
  Time: 9:59
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
<br/>
<div align="center">
    <c:forEach var="comment" items="${commentList}">
        <div class="comment">
            <div class="comment-body">
                <div class="comment-creator">
                    <div class="comment-creator-avatar">
                        <img alt="NO AVATAR" class="comment-creator-avatar-img" src="data:image/jpg;base64,${comment.getUser().getEncodedAvatar()}">
                    </div>
                    <div class="comment-creator-name">
                        <c:out value="${comment.getUser().getLogin()}"/>:
                    </div>
                </div>
                <div class="comment-content">
                     <c:out value="${comment.getContent()}"/>
                </div>
            </div>
            <div class="comment-footer">
                <div class="comment-button">
                    <form action="/creatures" method="post">
                        <input type="hidden" name="commandType" value="DELETE_COMMENT_COMMAND"/>
                        <input type="hidden" name="commentId" value="${comment.getId()}"/>
                        <input type="submit" value="<fmt:message key="button.delete"/>" class="nice-button"/>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
</fmt:bundle>
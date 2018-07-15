<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.07.2018
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creating comment</title>
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
    <form action="/creatures" method="post">
        <input type="hidden" name="commandType" value="COMMENT_CREATURE_COMMAND"/>
        <input type="hidden" name="creatureId" value="${creatureId}"/>
        <label for="comment">Comment</label><br/>
        <textarea id="comment" name="comment" class="input-text"></textarea>
        <br/><br/>
        <input type="submit" value="Post comment" class="nice-button"/>
    </form>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>

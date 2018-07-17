<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13.07.2018
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
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
<div align="right">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="SELF_DELETE_COMMAND"/>
        <input type="submit" value="Delete account" class="nice-button"/>
    </form>
</div>
<div align="center">
    <form action="/upload" enctype="multipart/form-data" method="post">
        <input type="hidden" name="pictureType" value="USER_AVATAR"/>
        <input type="hidden" name="userId" value="${id}"/>
        <input type="file" name="picture" accept="image/x-png, image/gif, image/jpeg" formenctype="multipart/form-data" maxlength="3072" required class="nice-button"/>
        <br/><br/>
        <input type="submit" value="Update avatar" class="nice-button"/>
    </form>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>

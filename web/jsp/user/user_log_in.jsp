<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01.07.2018
  Time: 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User authorization</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="../header.jsp"/>
<div align="left">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_START_PAGE_COMMAND"/>

        <input type="submit" name="to_start_page_button" value="Start Page" class="nice-button"/>
    </form>
</div>

<div align="center">
    <form action="/creatures" method="post">
        <input type="hidden" name="commandType" value="USER_AUTHORIZATION_COMMAND"/>

        <label for="login">Login</label><br/>
        <input type="text" name="login" id="login" class="input-text" maxlength="40"/>
        <br/><br/>

        <label for="password">Password</label><br/>
        <input type="password" name="password" id="password" class="input-text" maxlength="40"/>
        <br/><br/>

        <input type="submit" name="log_in_button" value="Log in" class="nice-button"/>
    </form>
</div>
</body>
</html>

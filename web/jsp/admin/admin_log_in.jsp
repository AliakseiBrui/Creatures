<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 30.06.2018
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Admin authorization</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../header.jsp"%>
<div align="left">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_START_PAGE_COMMAND"/>

        <input type="submit" name="to_start_page_button" value="Start Page" class="nice-button"/>
    </form>
</div>

<div align="center">
    <form action="/creatures" method="post">
        <input type="hidden" name="commandType" value="ADMIN_AUTHORIZATION_COMMAND"/>

        <jsp:include page="../parts/enter_user_data_part.jsp"/>

        <input type="submit" name="log_in_button" value="Log in" class="nice-button"/>
    </form>
</div>
</body>
</html>

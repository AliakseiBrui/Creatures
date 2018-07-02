<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 02.07.2018
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User registration</title>
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
    <jsp:include page="../sign_in_form.jsp"/>
</div>
</body>
</html>

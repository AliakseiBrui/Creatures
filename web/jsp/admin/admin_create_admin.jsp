<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Creating admin</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../parts/header.jsp"%>
<div align="left">
    <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_ADMIN_MAIN_PAGE_COMMAND"/>

        <input type="submit" name="to_main_page_button" value="Main Page" class="nice-button"/>
    </form>
</div>

<div align="center">
    <form action="/creatures" method="post">
        <input type="hidden" name="commandType" value="CREATE_ADMIN_COMMAND"/>

        <jsp:include page="../parts/enter_user_data_part.jsp"/>

        <input type="submit" value="Create" class="nice-button"/>
    </form>
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>

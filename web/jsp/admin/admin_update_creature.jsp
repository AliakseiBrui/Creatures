<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Creating creature</title>
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
        <input type="hidden" name="commandType" value="UPDATE_CREATURE_COMMAND"/>

        <input type="hidden" name="creatureId" value="${creature.getCreatureId()}">

        <jsp:include page="../parts/update_creature_data.jsp"/>

        <input type="submit" value="Update" class="nice-button"/>
    </form>

</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.07.2018
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creature details</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../header.jsp"%>
<div align="center">
    <br/>
    <c:import url="/creatures?commandType=SHOW_CREATURE_COMMENTS_COMMAND"/>
</div>
</body>
</html>

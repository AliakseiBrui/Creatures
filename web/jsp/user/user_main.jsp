<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01.07.2018
  Time: 4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Page</title>

</head>
<body>
<jsp:include page="../header.jsp"/>

<c:import url="/creatures?commandType=SHOW_CREATURES_COMMAND"/>
</body>
</html>

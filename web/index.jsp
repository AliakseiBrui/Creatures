<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26.06.2018
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Start page</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <div>
    <div style="float: left;">
      <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_ADMIN_AUTHORIZATION_PAGE_COMMAND"/>

        <input type="submit" value="Log in as admin" class="nice-button"/>
      </form>
    </div>
    <div style="float: right;">
      <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_USER_AUTHORIZATION_PAGE_COMMAND"/>

        <input type="submit" value="Log in as user" class="nice-button"/>
      </form>
    </div>
  </div>
  </body>
</html>

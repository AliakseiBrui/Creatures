<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26.06.2018
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<html>
  <head>
    <title>Start page</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <%@ include file="jsp/parts/header.jsp"%>
  <div style="padding: 5%;">
    <div align="center">
      <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_ADMIN_AUTHORIZATION_PAGE_COMMAND"/>

        <input type="submit" value="<fmt:message key="button.admin_log_in"/>" class="nice-button"/>
      </form>
    </div>
    <br>

    <div align="center">
      <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_USER_AUTHORIZATION_PAGE_COMMAND"/>

        <input type="submit" value="<fmt:message key="button.user_log_in"/>" class="nice-button"/>
      </form>
    </div>
    <br>

    <div align="center">
      <form action="/creatures" method="get">
        <input type="hidden" name="commandType" value="TO_USER_REGISTRATION_PAGE_COMMAND"/>

        <input type="submit" value="<fmt:message key="button.sign_in"/>" class="nice-button"/>
      </form>
    </div>
  </div>
  <%@ include file="jsp/parts/footer.jsp"%>
  </body>
</html>
</fmt:bundle>

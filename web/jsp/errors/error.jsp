<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 18.07.2018
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error page</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="../parts/header.jsp"%>
<div>
    Request from ${pageContext.errorData.requestURI} is failed
    <br/><br/>
    Servlet name: ${pageContext.errorData.servletName}
    <br/><br/>
    Status code: ${pageContext.exception}
    <br/><br/>
    Exception: ${pageContext.exception}
    <br/><br/>
    Message from exception: ${pageContext.exception.message}
</div>
<%@ include file="../parts/footer.jsp"%>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01.07.2018
  Time: 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
    <div class="header">
        <div class="header-left">
        </div>
        <div  class="header-right">
            <ctg:client-info/>
        </div>
    </div>
    <br/>
    <div align="center">
        <strong class="error-message">
            <c:out value="${errorMessage}"/>
        </strong>
        <strong class="succeed-message">
            <c:out value="${message}"/>
        </strong>
    </div>
    <br/>


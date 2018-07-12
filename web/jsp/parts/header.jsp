<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:if test="${not empty login}">
                <div class="header-panel">
                    <c:out value="Login: ${login} | Role: ${clientRole} | ID: ${id}"/>
                    <c:if test="${clientRole=='USER'}">
                        <c:out value=" | Status: ${status}"/>
                    </c:if>
                </div>
                <br/>
                <div align="right">
                    <form action="/creatures" method="get">
                        <input type="hidden" name="commandType" value="LOG_OUT_COMMAND"/>
                        <input type="submit" value="Log out" class="nice-button"/>
                    </form>
                </div>
            </c:if>
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


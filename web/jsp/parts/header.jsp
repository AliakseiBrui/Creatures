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
            <c:if test="${not empty login}">
                <div class="user">
                    <div class="user-body">
                        <br/>
                        <div class="user-avatar" align="center">
                            <%@ include file="../parts/avatar_part.jsp"%>
                        </div>
                        <br/>
                        <div class="user-role">
                            <c:out value="${clientRole}"/>
                        </div>
                        <div class="user-name">
                            <c:out value="${login}"/>
                        </div>
                    </div>
                    <div class="user-footer">
                        <c:if test="${clientRole=='USER'}">
                            <div class="user-status">
                                <c:out value="${status}"/>
                            </div>
                        </c:if>
                    </div>
                </div>
                <br/>
                <c:choose>
                    <c:when test="${clientRole=='USER'}">
                        <div align="right">
                            <form action="/creatures" method="get">
                                <input type="hidden" name="commandType" value="TO_USER_CHANGE_AVATAR_PAGE_COMMAND"/>
                                <input type="submit" value="Change avatar" class="nice-button"/>
                            </form>
                        </div>
                    </c:when>
                    <c:when test="${clientRole=='ADMIN'}">
                        <div align="right">
                            <form action="/creatures" method="get">
                                <input type="hidden" name="commandType" value="TO_ADMIN_CHANGE_AVATAR_PAGE_COMMAND"/>
                                <input type="submit" value="Change avatar" class="nice-button"/>
                            </form>
                        </div>
                    </c:when>
                </c:choose>
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


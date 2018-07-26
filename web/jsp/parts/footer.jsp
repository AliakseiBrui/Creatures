<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15.07.2018
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<br/><br/>
<div class="footer">
    <div class="footer-left">
        <div class="footer-logo">
            <img class="footer-logo-img" alt="NO LOGO" src="../../pics/logo.png">
        </div>
        <p><fmt:message key="copyright"/></p>
    </div>
    <div class="footer-right">
        <form id="langForm" action="/creatures" method="get">
            <input type="hidden" name="commandType" value="CHANGE_LANGUAGE_COMMAND"/>
            <select class="custom-select" name="locale" oninput="document.getElementById('langForm').submit()">
                <option hidden><fmt:message key="label.lang"/></option>
                <option value="en_US"><fmt:message key="label.lang.eng"/></option>
                <option value="ru_RU"><fmt:message key="label.lang.rus"/></option>
            </select>
        </form>
    </div>
</div>
</fmt:bundle>
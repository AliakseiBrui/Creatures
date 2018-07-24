<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 02.07.2018
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<label for="login"><fmt:message key="label.user.login"/></label><br/>
<input type="text" name="login" id="login" class="input-text" maxlength="10" required/>
<br/><br/>

<label for="password"><fmt:message key="label.user.password"/><label><br/>
<input type="password" name="password" id="password" class="input-text" maxlength="40" required/>
<br/><br/>
</fmt:bundle>


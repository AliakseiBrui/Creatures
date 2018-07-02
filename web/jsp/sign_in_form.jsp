<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 02.07.2018
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/creatures" method="post">
    <input type="hidden" name="commandType" value="USER_REGISTRATION_COMMAND"/>

    <label for="login">Login</label><br/>
    <input type="text" name="login" id="login" class="input-text" maxlength="40"/>
    <br/><br/>

    <label for="password">Password</label><br/>
    <input type="password" name="password" id="password" class="input-text" maxlength="40"/>
    <br/><br/>

    <input type="submit" value="Sign in" class="nice-button"/>
</form>

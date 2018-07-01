<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13.06.2018
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Application</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div align="center">
    <table width="100% ">
        <caption align="center" class="nice-text">
            Creatures
        </caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Limb quantity</th>
            <th>Head quantity</th>
            <th>Eye quantity</th>
            <th>Gender</th>
            <th>Description</th>
            <th>Creator</th>
            <th>Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="creature" items="${creatureList}">
            <tr>
                <td><c:out value="${creature.getCreatureId()}"/></td>
                <td><c:out value="${creature.getCreatureName()}"/></td>
                <td><c:out value="${creature.getLimbQuantity()}"/></td>
                <td><c:out value="${creature.getHeadQuantity()}"/></td>
                <td><c:out value="${creature.getEyeQuantity()}"/></td>
                <td><c:out value="${creature.getCreatureGender()}"/></td>
                <td><c:out value="${creature.getDescription()}"/></td>
                <td><c:out value="${creature.getCreatorId()}"/></td>
                <td><c:out value="${creature.getCreatureRating()}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
</div>
</body>
</html>
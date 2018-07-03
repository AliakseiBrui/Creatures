<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 19:21
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
    <table width="80%">
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
            <th></th>
            <th></th>
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
                <td>
                    <form action="/creatures" method="get">
                        <input type="hidden" name="commandType" value="TO_UPDATE_CREATURE_PAGE_COMMAND"/>

                        <input type="hidden" name="creatureId" value="${creature.getCreatureId()}"/>
                        <input type="hidden" name="creatureName" value="${creature.getCreatureName()}"/>
                        <input type="hidden" name="creatureLimbQuantity" value="${creature.getLimbQuantity()}"/>
                        <input type="hidden" name="creatureHeadQuantity" value="${creature.getHeadQuantity()}"/>
                        <input type="hidden" name="creatureEyeQuantity" value="${creature.getEyeQuantity()}"/>
                        <input type="hidden" name="creatureGender" value="${creature.getCreatureGender()}"/>
                        <input type="hidden" name="creatureDescription" value="${creature.getDescription()}"/>

                        <input type="submit" value="Update" class="nice-table-button"/>
                    </form>
                </td>
                <td>
                    <form action="/creatures" method="get">
                        <input type="hidden" name="commandType" value="DELETE_CREATURE_COMMAND"/>

                        <input type="hidden" name="creatureId" value="${creature.getCreatureId()}"/>

                        <input type="submit" value="Delete" class="nice-table-button"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
</div>
</body>
</html>

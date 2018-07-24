<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
<label for="creatureName"><fmt:message key="label.creature.name"/></label><br/>
<input type="text" name="creatureName" id="creatureName" class="input-text" maxlength="10" pattern="^[^\s]+" value="${creature.getCreatureName()}" required/>
<br/><br/>

<label for="creatureLimbQuantity"><fmt:message key="label.creature.limb_q"/></label><br/>
<input type="number" name="creatureLimbQuantity" id="creatureLimbQuantity" class="input-text" min="0" max="100" value="${creature.getLimbQuantity()}" required/>
<br/><br/>

<label for="creatureHeadQuantity"><fmt:message key="label.creature.head_q"/></label><br/>
<input type="number" name="creatureHeadQuantity" id="creatureHeadQuantity" class="input-text" min="0" max="100" value="${creature.getHeadQuantity()}" required/>
<br/><br/>

<label for="creatureEyeQuantity"><fmt:message key="label.creature.eye_q"/></label><br/>
<input type="number" name="creatureEyeQuantity" id="creatureEyeQuantity" class="input-text" min="0" max="100" value="${creature.getEyeQuantity()}" required/>
<br/><br/>

<label for="creatureGender"><fmt:message key="label.creature.gender"/></label><br/>
<select id="creatureGender" name="creatureGender"  class="index-text">
    <option><fmt:message key="label.creature.gender.none"/></option>
    <option><fmt:message key="label.creature.gender.male"/></option>
    <option><fmt:message key="label.creature.gender.female"/></option>
</select>
<br/><br/>

<label for="creatureDescription">Description</label><br/>
<textarea id="creatureDescription" name="creatureDescription" class="input-text"><c:out value="${creature.getDescription()}"/></textarea>
<br/><br/>
</fmt:bundle>
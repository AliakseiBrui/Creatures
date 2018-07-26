<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:bundle basename="resource.text">
    <label for="creatureName"><fmt:message key="label.creature.name"/></label><br/>
    <input type="text" name="creatureName" id="creatureName" class="input-text" maxlength="20" pattern="\p{Alpha}+[\w\s]+" required/>
    <br/><br/>

    <label for="creatureLimbQuantity"><fmt:message key="label.creature.limb_q"/></label><br/>
    <input type="number" name="creatureLimbQuantity" id="creatureLimbQuantity" class="input-text" min="0" max="100" value="0" required/>
    <br/><br/>

    <label for="creatureHeadQuantity"><fmt:message key="label.creature.head_q"/></label><br/>
    <input type="number" name="creatureHeadQuantity" id="creatureHeadQuantity" class="input-text" min="0" max="100" value="0" required/>
    <br/><br/>

    <label for="creatureEyeQuantity"><fmt:message key="label.creature.eye_q"/></label><br/>
    <input type="number" name="creatureEyeQuantity" id="creatureEyeQuantity" class="input-text" min="0" max="100" value="0" required/>
    <br/><br/>

    <label for="creatureGender"><fmt:message key="label.creature.gender"/></label><br/>
    <select id="creatureGender" name="creatureGender" class="index-text">
        <option value="NONE"><fmt:message key="label.creature.gender.none"/></option>
        <option value="MALE"><fmt:message key="label.creature.gender.male"/></option>
        <option value="FEMALE"><fmt:message key="label.creature.gender.female"/></option>
    </select>
    <br/><br/>

    <label for="creatureDescription"><fmt:message key="label.creature.description"/></label><br/>
    <textarea id="creatureDescription" name="creatureDescription" class="input-text" maxlength="200"></textarea>
    <br/><br/>
</fmt:bundle>

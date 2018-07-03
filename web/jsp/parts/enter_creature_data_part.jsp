<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 03.07.2018
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<label for="creatureName">Name</label><br/>
<input type="text" name="creatureName" id="creatureName" class="input-text" maxlength="40" pattern="^[^\s]+" value=" "/>
<br/><br/>

<label for="creatureLimbQuantity">Limb quantity</label><br/>
<input type="number" name="creatureLimbQuantity" id="creatureLimbQuantity" class="input-text" min="0" max="100" value="0"/>
<br/><br/>

<label for="creatureHeadQuantity">Head quantity</label><br/>
<input type="number" name="creatureHeadQuantity" id="creatureHeadQuantity" class="input-text" min="0" max="100" value="0"/>
<br/><br/>

<label for="creatureEyeQuantity">Eye quantity</label><br/>
<input type="number" name="creatureEyeQuantity" id="creatureEyeQuantity" class="input-text" min="0" max="100" value="0"/>
<br/><br/>

<label for="creatureGender">Gender</label><br/>
<select id="creatureGender" name="creatureGender" class="index-text">
    <option>NONE</option>
    <option>MALE</option>
    <option>FEMALE</option>
</select>
<br/><br/>

<label for="creatureDescription">Description</label><br/>
<input type="text" name="creatureDescription" id="creatureDescription" class="input-text" maxlength="100" style="row-span: initial;"/>
<br/><br/>

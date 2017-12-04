<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Library</title>
  <style><%@include file="/resources/web-style.css"%></style>
</head>

<body>
<div class="containers">
  <div class="upper">
    <h2>A resource for reading books</h2>
  </div>
<div class="context">
<sf:form method="post" modelAttribute="user" action="/check-user">
      <label class="label_login" for="user_login">Login:</label>
      <sf:input path="login" id="user_login" size="20" maxlength="25"/>
      <span class="error"><sf:errors path="login"/></span><br/>
      <label for="user_password">Password:</label>
      <sf:password path="password" showPassword="true" size="20" maxlength="40" id="user_password"/>
      <span class="error"><sf:errors path="password"/></span><br/>

      <div class="button_entrance"><td><sf:button id="button_entrance">Enter</sf:button></td></div>

</sf:form>
  <a class="url_reg_button" href="<s:url value="/registration"/>">Registration</a><br/>
</div>
</div>
</body>

</html>

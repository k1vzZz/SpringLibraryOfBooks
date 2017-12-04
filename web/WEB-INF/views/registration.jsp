<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        <%@include file="/resources/web-style.css" %>
    </style>
</head>
<body>
<div class="containers">
    <div class="upper">
        <h2>Registration</h2>
    </div>
    <div class="context">
        <sf:form method="post" modelAttribute="user" action="/registration">
            <label for="user_login">Login:</label>
            <sf:input path="login" maxlength="25" size="20" id="user_login"/>
            <span class="error"><sf:errors path="login"/></span><br/>
            <label for="user_password">Password:</label>
            <sf:password path="password" showPassword="true" size="20" maxlength="40" id="user_password"/>
            <span class="error"><sf:errors path="password"/></span><br/>
            <label for="confirm_password">Confirm Password:</label>
            <sf:password path="confirmPassword" showPassword="true" size="20" maxlength="40" id="confirm_password"/>
            <span class="error"><sf:errors path="confirmPassword"/></span><br/>
            <sf:button id="button_create">Create Account</sf:button>
        </sf:form>
        <c:if test="${message != null}">
            <div class="error"><c:out value="${message}"/><br/></div>
        </c:if>
        <a class="url_reg_button" href="<s:url value="/home"/>">Back</a>
    </div>
</div>
</body>
</html>

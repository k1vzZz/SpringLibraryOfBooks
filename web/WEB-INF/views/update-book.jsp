<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <style><%@include file="/resources/web-style.css"%></style>
</head>
<body>
<header>
    <h2>Library</h2>
    <nav>
        <label>Login:</label>
        <label>${user.login}</label><br/>
        <a class="url_reg_button" href="<s:url value="/exit"/>">Exit</a>
    </nav>
</header>
<div class="containers">
    <div class="context">
<sf:form method="post" modelAttribute="book" action="/library/${book.id}/update">
            <label for="name_book">Name book:</label>
            <sf:input path="name" id="name_book" size="20" maxlength="40"/>
            <span class="error"><sf:errors path="name"/></span><br/>
            <label for="genre">Genre:</label>
            <sf:input path="genre" id="genre" size="20" maxlength="20"/>
            <span class="error"><sf:errors path="genre"/></span><br/>
            <label for="year">Year:</label>
            <sf:input path="year" id="year" size="20" maxlength="4"/>
            <span class="error"><sf:errors path="year"/></span><br/>
            <label for="name_author">Author:</label>
            <sf:input path="author" size="20" maxlength="100" id="name_author"/>
            <span class="error"><sf:errors path="author"/></span><br/>
            <sf:button id="button_update">Update</sf:button>
</sf:form>
<a class="url_reg_button" href="<s:url value="/library/${book.id}"/>">Cancel</a>
    </div>
</div>
</body>
</html>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
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
<div class="scene_library">
    <div class="book">
        <label>Books:</label>
        <a class="url_reg_button" href="<s:url value="/library/add"/>">Add</a>
    </div>

<table class="table_col">
    <tr>
        <th><label>Name book</label></th>
        <th><label>Genre</label></th>
        <th><label>Year</label></th>
        <th><label>Author</label></th>
    </tr>
<c:forEach items="${books}" var="book">
    <tr>
        <td><a href="<s:url value="/library/${book.id}"/>">${book.name}</a></td>
        <td><c:out value="${book.genre}"/></td>
        <td><c:out value="${book.year}"/></td>
        <td><c:out value="${book.author}"/></td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>

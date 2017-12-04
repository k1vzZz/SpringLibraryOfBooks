<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book ${book.name}</title>
    <style><%@include file="/resources/web-style.css"%></style>
</head>
<body>
<header>
    <h2>Library</h2>
    <nav>
        <label>Login:</label>
        <label>${user.login}</label><br/>
        <a class="url_reg_button" href="<s:url value="/exit"/>">Exit</a><br/>
        <a class="url_reg_button" href="<s:url value="/library"/>">Back to menu</a>
    </nav>
</header>
<div class="scene_library">
<h3>Information about the book ${book.name}</h3>
    <div class="center_url">
        <c:if test="${user.id == book.idAdmin || user.login == 'admin'}">
            <tr>
                <td><a class="url_reg_button" href="<s:url value="/library/${book.id}/update"/>">Update</a></td>
                <td><a class="url_reg_button" href="<s:url value="/library/delete?id=${book.id}"/>">Delete</a></td>
            </tr>
        </c:if>
    </div>
<div class="table_col">
<table>
    <colgroup>
        <col style="background:#8DC26F;">
    </colgroup>
    <tr>
        <td><label>Name book:</label></td>
        <td><c:out value="${book.name}"/></td>
    </tr>
    <tr>
        <td><label>Genre:</label></td>
        <td><c:out value="${book.genre}"/></td>
    </tr>
    <tr>
        <td><label>Year:</label></td>
        <td><c:out value="${book.year}"/></td>
    </tr>
    <tr>
        <td><label>Author:</label></td>
        <td><c:out value="${book.author}"/></td>
    </tr>
</table>
</div>
</div>
</body>
</html>

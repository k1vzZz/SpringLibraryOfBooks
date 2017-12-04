<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
    <style>
        <%@include file="/resources/web-style.css" %>
    </style>
</head>
<body>
<table>
    <tr>
        <td>
            <c:out value="${message}"/>
        </td>
    </tr>
</table>
<c:if test="${inputError != null}">
    <a class="url_reg_button" href="<s:url value="/home"/>">OK</a>
</c:if>
<c:if test="${inputError == null}">
    <c:if test="${suffix!=null}">
        <a href="<s:url value="/library/${suffix}"/>">OK</a>
    </c:if>
    <c:if test="${suffix==null}">
        <a class="url_reg_button" href="<s:url value="/library"/>">OK</a>
    </c:if>
</c:if>
</body>
</html>

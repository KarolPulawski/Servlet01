<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: drogba
  Date: 02.08.18
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty error}">
        <section class="error">${error}</section>
    </c:if>

    <c:if test="${not empty start && not empty end && start<=end}">
        <ul>
            <c:forEach begin="${start}" end="${end}" var="i">
                <li>${-i}</li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>

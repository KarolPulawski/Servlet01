<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: drogba
  Date: 02.08.18
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>
                    <c:out value="${book.title}"></c:out>
                    <c:out value="${book.author}"></c:out>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>



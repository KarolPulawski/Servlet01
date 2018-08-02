<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Books</h1>
    <a href=<c:url value="/Mvc15"/> >Add</a>
    <a href=<c:url value="/Mvc152"/> >Add 3 books</a>

    <table>
        <c:forEach items="${books_list}" var="book">
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

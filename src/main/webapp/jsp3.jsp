<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display values</title>
</head>
<body>
    <c:if test="${ empty param.a || empty param.b}">
        <h3>Lack of parameters</h3>
    </c:if>
    <c:if test="${ not empty param.a && not empty param.b}">
        <h3> <c:out value="a: ${param.a} b: ${param.b}"/> </h3>
    </c:if>

</body>
</html>

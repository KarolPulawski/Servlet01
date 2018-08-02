<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test = "${empty param.km}">
        <h1>Brak parametrow</h1>
    </c:if>

    <c:if test="${not empty param.km}">
        <h1>Calculate for  <c:out value ="${param.km}" default = ": lack of value"/></h1>
        <p>${param.km}km * 1,609344 = ${param.km * 1.609344}miles</p>
    </c:if>

<%--
    <h1>Calculate for  <c:out value ="${param.km}" default = ": lack of value"/></h1>
    <c:if test = "${param.km > 0}">
        <p>${param.km}km * 1,609344 = ${param.km * 1.609344}miles</p>
    </c:if>
    --%>
</body>
</html>

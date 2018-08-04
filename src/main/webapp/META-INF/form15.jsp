<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/mvcJdbc01">
    <label>
        <input type = "text" name ="title" placeholder="title">
        <input type = "text" name ="author" placeholder="author">
        <input type = "text" name ="isbn" placeholder="isbn">
    </label>
    </br>
    <input type = "submit" value="Send">
</form>
</body>
</html>

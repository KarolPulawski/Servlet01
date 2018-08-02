<%--
  Created by IntelliJ IDEA.
  User: drogba
  Date: 02.08.18
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/mvc13">
        <label>
            <input type = "text" name ="title" placeholder="title">
            <input type = "text" name ="author" placeholder="author">
            <input type = "text" name ="isbn" placeholder="isbn">
        </label>
        <input type = "submit" value="Send">
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2/28/2025
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Success Page</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user") %>, Login Successfull.</h3>
<a href = "login.html">Login Page</a>
</body>
</html>

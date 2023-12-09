<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="./css/Login.css">
</head>
<body>
    <div class="container">
    	<h1>Admin Login</h1>
        <form action="AdminLogin" method="post">
            <label for="adminname">Username:</label>
            <input type="text" id="adminname" name="adminname"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
    <a class="back" href="${pageContext.request.contextPath}/index.jsp">Back</a>
</body>
</html>

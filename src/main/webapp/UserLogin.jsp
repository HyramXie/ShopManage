<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="./css/Page.css">
</head>
<body>
    <div class="container">
    	<h1>Login</h1>
        <form action="login.user" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br>
            <input type="submit" value="Submit"><br>
        </form>
        <a href="./Register.jsp">Register</a>
    </div>
</body>
</html>

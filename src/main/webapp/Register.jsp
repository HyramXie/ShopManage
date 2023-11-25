<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="./css/Page.css">
</head>
<body>
    <div class="container">
   		 <h1>Register</h1>
        <form action="regist.user" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br>
            <label for="phone">PhoneNumber:</label>
            <input type="text" id="phone" name="phone"><br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

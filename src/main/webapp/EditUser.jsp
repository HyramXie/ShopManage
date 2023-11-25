<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User Information</title>
    <link rel="stylesheet" href="./css/editUser.css">
</head>
<body>
    <div class="container">
        <h1>Edit User Information</h1>
        <form action="edit.user" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="${sessionScope.user.getUsername()}"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${sessionScope.user.getPassword()}"><br>
            <label for="phone">PhoneNumber:</label>
            <input type="text" id="phone" name="phone" value="${sessionScope.user.getPhoneNumber()}"><br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="${sessionScope.user.getEmail()}"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

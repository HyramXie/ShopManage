<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Category</title>
    <link rel="stylesheet" href="./css/editUser.css">
</head>
<body>
    <div class="container">
        <h1>Update Category</h1>
        <form action="UpdateCategory" method="post">
        	<input type="hidden" id="id" name="id" value="${requestScope.category.getCategoryID() }">
            <label for="name">Category:</label>
            <input type="text" id="name" name="name" value="${requestScope.category.getCategoryName() }"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

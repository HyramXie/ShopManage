<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" href="./css/editUser.css">
</head>
<body>
    <div class="container">
        <h1>Add Product</h1>
        <form action="AddProduct" method="post">
            <label for="name">Product:</label>
            <input type="text" id="name" name="name"><br>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price"><br>
            <label for="stock">Stock:</label>
            <input type="text" id="stock" name="stock" ><br>
            <label for="categoryid">Category:</label>
            <select name="categoryid" class="selector">
            	<c:forEach items="${sessionScope.categories}" var="cate" >
            		<option value="${cate.getCategoryID()}">${cate.getCategoryName()}</option>
            	</c:forEach>
        	</select><br>
        	<input type="submit" value="Submit">
        </form>
       
    </div>
</body>
</html>

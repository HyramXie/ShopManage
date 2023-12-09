<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
    <link rel="stylesheet" href="./css/Edit.css">
</head>
<body>
    <div class="container">
       <h1>Update Cart</h1>
        <form action="UpdateCartItem" method="post">
        	<input type="hidden" id="id" name="id" value="${param.id}">
        	<label for="name">Product:</label>
        	<input type="hidden" id="name" name="name" value="${param.name}">
            <p>${param.name}</p><br>
            <label for="quantity">Quantity:</label>
            <input type="text" id="quantity" name="quantity" value="${param.quantity }"><br>
            <input type="submit" value="Submit">
            <c:if test="${requestScope.result}"><label>Too much</label></c:if>
        </form>
    </div>
    <a class="back" href="${pageContext.request.contextPath}/ShopCart">Back</a>
</body>
</html>

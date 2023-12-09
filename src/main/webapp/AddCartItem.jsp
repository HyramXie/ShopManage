<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add CartItem</title>
    <link rel="stylesheet" href="./css/Edit.css">
</head>
<body>
    <div class="container">
        <h1>Add CartItem</h1>
        <form action="AddCartItem" method="post">
        	 <input hidden="hidden" type="text" id="id" name="id" value="${param.id}">
            <label for="name">Product:</label>
            <input hidden="hidden" type="text" id="name" name="name" value="${param.name}">
            <p>${param.name}</p><br>
            <label for="price">Price:</label>
            <input hidden="hidden" type="text" id="price" name="price" value="${param.price}">
            <p>${param.price}</p><br>
            <label for="stock">Stock:</label>
            <input hidden="hidden" type="text" id="stock" name="stock" value="${param.stock}">
            <p>${param.stock}</p><br>
            <label for="categoryid">Category:</label>
            <input hidden="hidden" type="text" id="cname" name="cname" value="${param.cname}">
            <p>${param.cname}</p><br>
            <label for="quantity">Quantity:</label>
            <input type="text" id="quantity" name="quantity" ><br>
        	<input type="submit" value="Submit">
        	<c:if test="${requestScope.result}"><label>Too much</label></c:if>
        </form>
        <a class="back" href="${pageContext.request.contextPath}/Product.jsp">Back</a>
    </div>
</body>
</html>

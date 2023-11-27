<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
    <link rel="stylesheet" href="./css/editUser.css">
</head>
<body>
    <div class="container">
        <h1>Update Product</h1>
        <form action="UpdateProduct" method="post">
        	<input type="hidden" id="id" name="id" value="${requestScope.product.getProductID() }">
            <label for="name">Product:</label>
            <input type="text" id="name" name="name" value="${requestScope.product.getProductName() }"><br>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${requestScope.product.getPrice() }"><br>
            <label for="stock">Stock:</label>
            <input type="text" id="stock" name="stock" value="${requestScope.product.getStockQuantity() }"><br>
            <label for="categoryid">Category:</label>
            <select name="categoryid" class="selector">
            	<c:forEach items="${sessionScope.categories}" var="cate" >
            		<c:choose>
         			   	<c:when test="${cate.getCategoryID() eq requestScope.product.getCategoryID()}">
              			  	<option value="${cate.categoryID}" selected>${cate.categoryName}</option>
          			   	</c:when>
            			<c:otherwise>
                			<option value="${cate.categoryID}">${cate.categoryName}</option>
            			</c:otherwise>
        			</c:choose>
            	</c:forEach>
        	</select><br>
        	<input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

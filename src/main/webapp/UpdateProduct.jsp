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
        <h1>Update Product</h1>
        <form action="UpdateProduct" method="post">
        	<input type="hidden" id="id" name="id" value="${param.id }">
            <label for="name">Product:</label>
            <input type="text" id="name" name="name" value="${param.name }"><br>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${param.price }"><br>
            <label for="stock">Stock:</label>
            <input type="text" id="stock" name="stock" value="${param.stock }"><br>
            <label for="categoryid">Category:</label>
            <select name="categoryid" class="selector">
            	<c:forEach items="${sessionScope.categories}" var="cate" >
            		<c:choose>
         			   	<c:when test="${cate.getCategoryID() eq param.categoryid}">
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
    <a class="back" href="${pageContext.request.contextPath}/ModifyProduct.jsp">Back</a>
</body>
</html>

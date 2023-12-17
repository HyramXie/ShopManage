<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
    <link rel="stylesheet" href="./css/edit.css">
</head>
<body>
    <div class="container">
        <h1>更新商品</h1>
        <form action="UpdateProduct" method="post">
        	<input type="hidden" id="id" name="id" value="${param.id }">
            <label for="name">商品:</label>
            <input type="text" id="name" name="name" value="${param.name }"><br>
            <label for="price">价格:</label>
            <input type="text" id="price" name="price" value="${param.price }"><br>
            <label for="stock">库存:</label>
            <input type="text" id="stock" name="stock" value="${param.stock }"><br>
            <label for="categoryid">商品类型:</label>
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
        	<input type="submit" value="提交">
        </form>
    </div>
    <a class="back" href="${pageContext.request.contextPath}/ModifyProduct.jsp">返回</a>
</body>
</html>

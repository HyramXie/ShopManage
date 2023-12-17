<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" href="./css/edit.css">
</head>
<body>
    <div class="container">
        <h1>添加商品</h1>
        <form action="AddProduct" method="post">
            <label for="name">商品名称:</label>
            <input type="text" id="name" name="name"><br>
            <label for="price">价格:</label>
            <input type="text" id="price" name="price"><br>
            <label for="stock">库存:</label>
            <input type="text" id="stock" name="stock" ><br>
            <label for="categoryid">商品类型:</label>
            <select name="categoryid" class="selector">
            	<c:forEach items="${sessionScope.categories}" var="cate" >
            		<option value="${cate.getCategoryID()}">${cate.getCategoryName()}</option>
            	</c:forEach>
        	</select><br>
        	<input type="submit" value="提交">
        </form>
       
    </div>
    <a class="back" href="${pageContext.request.contextPath}/Manage.jsp">返回</a>
</body>
</html>

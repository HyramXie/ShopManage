<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buy Product</title>
    <link rel="stylesheet" href="./css/edit.css">
</head>
<body>
    <div class="container">
        <h1>购买商品</h1>
        <form action="BuyProduct" method="post">
        	 <input hidden="hidden" type="text" id="id" name="id" value="${param.id}">
            <label for="name">商品:</label>
            <input hidden="hidden" type="text" id="name" name="name" value="${param.name}">
            <p>${param.name}</p><br>
            <label for="price">价格:</label>
            <input hidden="hidden" type="text" id="price" name="price" value="${param.price}">
            <p>${param.price}</p><br>
            <label for="stock">库存:</label>
            <input hidden="hidden" type="text" id="stock" name="stock" value="${param.stock}">
            <p>${param.stock}</p><br>
            <label for="categoryid">类型:</label>
            <input hidden="hidden" type="text" id="cname" name="cname" value="${param.cname}">
            <p>${param.cname}</p><br>
            <label for="quantity">数量:</label>
            <input type="text" id="quantity" name="quantity" ><br>
        	<input type="submit" value="提交">
        	<c:if test="${requestScope.result}"><label>库存不足</label></c:if>
        </form>
        <a class="back" href="${pageContext.request.contextPath}/Product.jsp">返回</a>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="./css/home.css">
</head>
<body>
    <div class="container">
        <h1>欢迎</h1>
        <div class="links">
            <a href="${pageContext.request.contextPath}/EditUser.jsp">编辑信息</a>
            <a href="${pageContext.request.contextPath}/Product?shop=1">商品列表</a>
            <a href="${pageContext.request.contextPath}/ShopCart">购物车</a>
            <a href="${pageContext.request.contextPath}/MyOrder">订单</a>
        </div>
    </div>
    
</body>
</html>

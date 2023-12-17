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
        <h1>管理</h1>
        <div class="links">
			<a href="${pageContext.request.contextPath}/AddCategory.jsp">添加商品类型</a>
            <a href="${pageContext.request.contextPath}/GetSelect">添加商品</a>
            <a href="${pageContext.request.contextPath}/ModifyCategory">商品类型列表</a>
            <a href="${pageContext.request.contextPath}/Product">商品列表</a>
            <a href="${pageContext.request.contextPath}/OrderDeal">订单交易</a>
        </div>
    </div>
</body>
</html>

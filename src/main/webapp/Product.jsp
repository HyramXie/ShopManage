<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Product</title>
    <link rel="stylesheet" href="./css/update.css">
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>商品</th>
                <th>价格</th>
                <th>库存</th>
                <th>商品类型</th>
                <th>添加购物车</th>
                <th>购买</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${sessionScope.products}" var="p" >
        		<c:if test="${p.getStatus() == 1}">
        		<tr>
                	<td>${p.getProductName()}</td>
                	<td>${p.getPrice()}</td>
                	<td>${p.getStockQuantity()}</td>
                	<td>${p.getCategoryName()}</td>
                	<td><a href="${pageContext.request.contextPath}/AddCartItem.jsp?id=${p.getProductID()}&cid=${p.getCategoryID()}&name=${p.getProductName()}&price=${p.getPrice()}&stock=${p.getStockQuantity()}&cname=${p.getCategoryName()}">添加</a></td>
                	<td><a href="${pageContext.request.contextPath}/BuyProduct.jsp?id=${p.getProductID()}&cid=${p.getCategoryID()}&name=${p.getProductName()}&price=${p.getPrice()}&stock=${p.getStockQuantity()}&cname=${p.getCategoryName()}">购买</a></td>
           		</tr>
           		</c:if>
            </c:forEach>
        </tbody>
    </table>
    <a class="back" href="${pageContext.request.contextPath}/Home.jsp">返回</a>
</body>
</html>

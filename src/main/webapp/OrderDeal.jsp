<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Order</title>
    <link rel="stylesheet" href="./css/order.css">
</head>
<body>
    <h1>Order</h1>
    <table border="1">
        <thead>
            <tr>
                <th>订单号</th>
                <th>商品</th>
                <th>订单日期</th>
                <th>价格</th>
                <th>订单交易</th>
                <th>订单详情</th>
            </tr>
        </thead>
        <tbody>
        		<c:forEach items="${requestScope.orders}" var="order" >
                    <tr>
                        <td>${order.getOrderID() }</td>
                        <td>
                        	<c:forEach items="${requestScope.orderItems}" var="orderItem" >
                        		<c:if test="${order.getOrderID() eq orderItem.getOrderID()}">
                        			<p>${orderItem.getProductName() }×${orderItem.getQuantity() }</p>
                        		</c:if>
	                        </c:forEach>
                        </td>
                        <td>${order.getOrderDate() }</td>
                        <td>${order.getPrice() }</td>
                        <td><a href="${pageContext.request.contextPath}/ManageChangeOrder?id=${order.getOrderID()}">
                        		<c:choose>
                        			<c:when test="${order.getStatus() == 0}">未支付</c:when>
									<c:when test="${order.getStatus() == 1}">发货</c:when>
									<c:when test="${order.getStatus() == 2}">已发货</c:when>
									<c:when test="${order.getStatus() == -1}">退款</c:when>
									<c:otherwise>订单完成</c:otherwise>
								</c:choose>
                        	</a>
                        </td>
                        <td><a href="${pageContext.request.contextPath}/OrderDetail?id=${order.getOrderID() }&manage=1">详情</a></td>
                    </tr>
                 </c:forEach>
        </tbody>
    </table>
	<a class="back" href="${pageContext.request.contextPath}/Manage.jsp">返回</a>
</body>
</html>

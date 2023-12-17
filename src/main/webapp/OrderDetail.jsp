<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Detail</title>
    <link rel="stylesheet" href="./css/edit.css">
</head>
<body>
    <div class="container">
        <h1>订单详情</h1>
        <form action="ChangeOrderStatus" method="post">
        	<input type="hidden" name="id" value="${requestScope.oneOrder.getOrderID()}">
            <label for="name">商品:</label>
            <c:forEach items="${requestScope.oneOrderItems}" var="orderItem" >
                  	<p>${orderItem.getProductName() }×${orderItem.getQuantity() }</p>
	        </c:forEach>
            <label for="price">价格:</label>
            <p>${requestScope.oneOrder.getPrice()}</p><br>
            <label for="date">订单日期:</label>
            <p>${requestScope.oneOrder.getOrderDate()}</p><br>
            <label for="status">状态:</label>
	           <p>
	            <c:choose>
					<c:when test="${requestScope.oneOrder.getStatus() == 0}">
						未付款
					</c:when>
					<c:when test="${requestScope.oneOrder.getStatus() == 1}">
						已付款
					</c:when>
					<c:when test="${requestScope.oneOrder.getStatus() == 2}">
						已发货
					</c:when>
					<c:when test="${requestScope.oneOrder.getStatus() == -1}">
						退款中
					</c:when>
					<c:when test="${requestScope.oneOrder.getStatus() == -2}">
						退款成功
					</c:when>
					<c:otherwise>
						已收货
					</c:otherwise>
				</c:choose>
			</p><br>
			<c:choose>
				<c:when test="${requestScope.oneOrder.getStatus() == 0}">
					<label for="name">收货人:</label>
					<input type="text" id="name" name="name" value="${requestScope.oneOrder.getName()}">
					<label for="phone">电话号码:</label>
					<input type="text" id="phone" name="phone" value="${requestScope.oneOrder.getPhone()}">
					<label for="address">地址:</label>
					<input type="text" id="address" name="address" value="${requestScope.oneOrder.getAddress()}">
				</c:when>
				<c:otherwise>
					<label for="name">收货人:</label>
					<p>${requestScope.oneOrder.getName()}</p>
					<label for="phone">电话号码:</label>
					<p>${requestScope.oneOrder.getPhone()}</p>
					<label for="address">地址:</label>
					<p>${requestScope.oneOrder.getAddress()}</p>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${requestScope.oneOrder.getStatus() == 0}">
					<input type="submit" value="支付">
				</c:when>
				<c:when test="${requestScope.oneOrder.getStatus() == 1}">
					<input type="submit" value="退款">
				</c:when>
				<c:when test="${requestScope.oneOrder.getStatus() == 2}">
					<input type="submit" name="action" value="签收"><br>
					<input type="submit" name="action" value="退款">
				</c:when>
				<c:when test="${requestScope.oneOrder.getStatus() == -1}">
					<input type="submit" value="取消">
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
        </form>
        <a class="back" href="${pageContext.request.contextPath}/MyOrder">返回</a>
    </div>
</body>
</html>

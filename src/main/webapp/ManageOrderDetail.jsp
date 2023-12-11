<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Detail</title>
    <link rel="stylesheet" href="./css/Edit.css">
</head>
<body>
    <div class="container">
        <h1>Order Detail</h1>
        <form action="ChangeOrderStatus" method="post">
        	<input type="hidden" name="id" value="${requestScope.oneOrder.getOrderID()}">
            <label for="name">Product:</label>
            <c:forEach items="${requestScope.oneOrderItems}" var="orderItem" >
                  	<p>${orderItem.getProductName() }×${orderItem.getQuantity() }</p>
	        </c:forEach>
            <label for="price">Price:</label>
            <p>${requestScope.oneOrder.getPrice()}</p><br>
            <label for="date">OrderDate:</label>
            <p>${requestScope.oneOrder.getOrderDate()}</p><br>
            <label for="status">Status:</label>
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
			<label for="address">Address:</label>
			<p>${requestScope.oneOrder.getAddress()}</p>
			<c:choose>
				<c:when test="${requestScope.oneOrder.getStatus() == 1}">
					<input type="submit" value="Deliver">
				</c:when>
				<c:when test="${requestScope.oneOrder.getStatus() == -1}">
					<input type="submit" value="Refund">
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
        </form>
		<a class="back" href="${pageContext.request.contextPath}/OrderDeal">Back</a>  
    </div>
</body>
</html>

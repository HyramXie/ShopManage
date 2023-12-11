<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Order</title>
    <link rel="stylesheet" href="./css/order.css">
</head>
<body>
    <h1>Order</h1>
    <table border="1">
        <thead>
            <tr>
                <th>OrderID</th>
                <th>Product</th>
                <th>OrderDate</th>
                <th>Price</th>
                <th>Deal</th>
                <th>Detail</th>
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
                        			<c:when test="${order.getStatus() == 0}">UnPay</c:when>
									<c:when test="${order.getStatus() == 1}">Deliver</c:when>
									<c:when test="${order.getStatus() == 2}">Delivered</c:when>
									<c:when test="${order.getStatus() == -1}">Refund</c:when>
									<c:otherwise>Success</c:otherwise>
								</c:choose>
                        	</a>
                        </td>
                        <td><a href="${pageContext.request.contextPath}/OrderDetail?id=${order.getOrderID() }&manage=1">detail</a></td>
                    </tr>
                 </c:forEach>
        </tbody>
    </table>
	<a class="back" href="${pageContext.request.contextPath}/Manage.jsp">Back</a>
</body>
</html>

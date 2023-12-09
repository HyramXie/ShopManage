<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product</title>
    <link rel="stylesheet" href="./css/Update.css">
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Category</th>
                <th>Add ShopCart</th>
                <th>Buy</th>
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
                	<td><a href="${pageContext.request.contextPath}/AddCartItem.jsp?id=${p.getProductID()}&cid=${p.getCategoryID()}&name=${p.getProductName()}&price=${p.getPrice()}&stock=${p.getStockQuantity()}&cname=${p.getCategoryName()}">Add</a></td>
                	<td><a href="${pageContext.request.contextPath}/BuyProduct.jsp?id=${p.getProductID()}&cid=${p.getCategoryID()}&name=${p.getProductName()}&price=${p.getPrice()}&stock=${p.getStockQuantity()}&cname=${p.getCategoryName()}">Buy</a></td>
           		</tr>
           		</c:if>
            </c:forEach>
        </tbody>
    </table>
    <a class="back" href="${pageContext.request.contextPath}/Home.jsp">Back</a>
</body>
</html>

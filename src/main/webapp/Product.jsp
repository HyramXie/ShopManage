<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product</title>
    <link rel="stylesheet" href="./css/Modify.css">
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Category</th>
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
                	<td><a href="${pageContext.request.contextPath}/SearchProduct?id=${p.getProductID()}&buy=1">Add</a></td>
           		</tr>
           		</c:if>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

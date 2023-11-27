<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
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
                <th>Up/Down</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${sessionScope.products}" var="p" >
        		<tr>
                	<td>${p.getProductName()}</td>
                	<td>${p.getPrice()}</td>
                	<td>${p.getStockQuantity()}</td>
                	<td>${p.getCategoryName()}</td>
                	<td><a href="${pageContext.request.contextPath}/ChangeStatus?id=${p.getProductID()}">
                		<c:choose>
                			<c:when test="${p.getStatus() == 1}">Down</c:when>
                			<c:otherwise>Up</c:otherwise>
                		</c:choose>
                	</a></td>
                	<td><a href="${pageContext.request.contextPath}/SearchProduct?id=${p.getProductID()}">Update</a></td>
                	<td><a href="${pageContext.request.contextPath}/DeleteProduct?id=${p.getProductID()}">Delete</a></td>
           		</tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

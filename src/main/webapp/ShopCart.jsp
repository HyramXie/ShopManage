<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="./css/List.css">
</head>
<body>
    <table>
        <thead>
            <tr>
            	<th></th>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${requestScope.cartItems}" var="cart" >
        		<tr>
        			
        			<td>
                            <input type="checkbox" name="product" value="${cart.getCartItemID()}">
					</td>
                	<td>${cart.getProductName()}</td>
                	<td>${cart.getPrice()}</td>
                	<td>${cart.getQuantity()}</td>
                	<td><a href="${pageContext.request.contextPath}/UpdateCartItem.jsp?name=${cart.getProductName()}&quantity=${cart.getQuantity()}">Update</a></td>
                	<td><a href="${pageContext.request.contextPath}/DeleteCartItem?id=${cart.getCartItemID()}">Delete</a></td>
           		</tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

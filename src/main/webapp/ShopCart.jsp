<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="./css/show.css">
</head>
<body>
	<form action="Submit" method="post">
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
	                            <input type="checkbox" name="id" value="${cart.getCartItemID()}">
						</td>
	                	<td>${cart.getProductName()}
	                			<input type="hidden" name="pid" value="${cart.getProductID()}">
	                	</td>
	                	<td>${cart.getPrice()*cart.getQuantity()}
	                		<input type="hidden" name="sum" value="${cart.getPrice()*cart.getQuantity()}">
	                	</td>
	                	<td>${cart.getQuantity()}
	                			<input type="hidden" name="quantity" value="${cart.getQuantity()}">
	                	</td>
	                	<td><a href="${pageContext.request.contextPath}/UpdateCartItem.jsp?id=${cart.getCartItemID()}&name=${cart.getProductName()}&quantity=${cart.getQuantity()}">Update</a></td>
	                	<td><a href="${pageContext.request.contextPath}/DeleteCartItem?id=${cart.getCartItemID()}">Delete</a></td>
	           		</tr>
	            </c:forEach>
	        </tbody>
	    </table><br>
	    <input type="submit" class="submit" value="Submit">
	    <a class="back" href="${pageContext.request.contextPath}/Home.jsp">Back</a>
	</form>
	
</body>
</html>

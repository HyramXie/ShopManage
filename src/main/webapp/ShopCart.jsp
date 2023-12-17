<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="./css/show.css">
</head>
<body>
	<form action="Submit" method="post">
	    <table>
	        <thead>
	            <tr>
	            	<th></th>
	                <th>商品</th>
	                <th>价格</th>
	                <th>库存</th>
	                <th>数量</th>
	                <th>更新</th>
	                <th>删除</th>
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
	                	<td>${cart.getPrice()*cart.getQuantity()}</td>
	                	<td>${cart.getStockQuantity()}</td>
	                	<td>${cart.getQuantity()}
	                			<input type="hidden" name="quantity" value="${cart.getQuantity()}">
	                	</td>
	                	<td><a href="${pageContext.request.contextPath}/UpdateCartItem.jsp?id=${cart.getCartItemID()}&name=${cart.getProductName()}&quantity=${cart.getQuantity()}">更新</a></td>
	                	<td><a href="${pageContext.request.contextPath}/DeleteCartItem?id=${cart.getCartItemID()}">删除</a></td>
	           		</tr>
	            </c:forEach>
	        </tbody>
	    </table><br>
	    <input type="submit" class="submit" value="提交">
	    <a class="back" href="${pageContext.request.contextPath}/Home.jsp">返回</a>
	</form>
	
</body>
</html>

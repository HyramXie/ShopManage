<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="./css/Update.css">
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>商品</th>
                <th>价格</th>
                <th>库存</th>
                <th>商品类型</th>
                <th>上架/下架</th>
                <th>更新</th>
                <th>删除</th>
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
                			<c:when test="${p.getStatus() == 1}">下架</c:when>
                			<c:otherwise>上架</c:otherwise>
                		</c:choose>
                	</a></td>
                	<td><a href="${pageContext.request.contextPath}/UpdateProduct.jsp?id=${p.getProductID()}&name=${p.getProductName()}&price=${p.getPrice()}&stock=${p.getStockQuantity()}&cname=${p.getCategoryName()}">更新</a></td>
                	<td><a href="${pageContext.request.contextPath}/DeleteProduct?id=${p.getProductID()}">删除</a></td>
           		</tr>
            </c:forEach>
        </tbody>
    </table>
    <a class="back" href="${pageContext.request.contextPath}/Manage.jsp">返回</a>
</body>
</html>

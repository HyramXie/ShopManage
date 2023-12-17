<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ModifyCategory</title>
    <link rel="stylesheet" href="./css/update.css">
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>类型名称</th>
                <th>更新</th>
                <th>删除</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${sessionScope.categories}" var="cate" >
        		<tr>
                	<td>${cate.getCategoryName()}</td>
                	<td><a href="${pageContext.request.contextPath}/UpdateCategory.jsp?id=${cate.getCategoryID()}&name=${cate.getCategoryName()}">更新</a></td>
                	<td><a href="${pageContext.request.contextPath}/DeleteCategory?id=${cate.getCategoryID()}">删除</a></td>
           		</tr>
            </c:forEach>
        </tbody>
    </table>
    
    <a class="back" href="${pageContext.request.contextPath}/Manage.jsp">Back</a>
</body>
</html>

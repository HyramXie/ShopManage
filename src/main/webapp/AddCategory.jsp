<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" href="./css/edit.css">
</head>
<body>
    <div class="container">
        <h1>添加类型</h1>
        <form action="AddCategory" method="post">
            <label for="name">类型名称:</label>
            <input type="text" id="name" name="name"><br>
        	<input type="submit" value="提交">
        </form>
    </div>
    <a class="back" href="${pageContext.request.contextPath}/Manage.jsp">返回</a>
</body>
</html>

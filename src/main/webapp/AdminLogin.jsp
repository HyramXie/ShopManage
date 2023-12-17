<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
    <div class="container">
    	<h1>管理员登录</h1>
        <form action="AdminLogin" method="post">
            <label for="adminname">管理员:</label>
            <input type="text" id="adminname" name="adminname"><br>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password"><br>
            <input type="submit" value="提交">
        </form>
    </div>
    <a class="back" href="${pageContext.request.contextPath}/index.jsp">返回</a>
</body>
</html>

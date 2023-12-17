<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
    <div class="container">
   		 <h1>注册</h1>
        <form action="regist.user" method="post">
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username"><br>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password"><br>
            <label for="phone">电话号码:</label>
            <input type="text" id="phone" name="phone"><br>
            <label for="email">邮箱:</label>
            <input type="text" id="email" name="email"><br>
            <label for="email">地址:</label>
            <input type="text" id="address" name="address"><br>
            <input type="submit" value="提交">
        </form>
    </div>
    <a class="back" href="${pageContext.request.contextPath}/UserLogin.jsp">返回</a>
</body>
</html>

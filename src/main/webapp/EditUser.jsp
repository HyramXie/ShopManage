<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User Information</title>
    <link rel="stylesheet" href="./css/edit.css">
</head>
<body>
    <div class="container">
        <h1>编辑信息</h1>
        <form action="edit.user" method="post">
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username" value="${sessionScope.user.getUsername()}"><br>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" value="${sessionScope.user.getPassword()}"><br>
            <label for="phone">电话号码:</label>
            <input type="text" id="phone" name="phone" value="${sessionScope.user.getPhoneNumber()}"><br>
            <label for="email">邮箱:</label>
            <input type="text" id="email" name="email" value="${sessionScope.user.getEmail()}"><br>
             <label for="email">地址:</label>
            <input type="text" id="address" name="address" value="${sessionScope.user.getAddress()}"><br>
            <input type="submit" value="提交">
            
        </form>
    </div>
   <a class="back" href="${pageContext.request.contextPath}/Home.jsp">返回</a>
</body>
</html>

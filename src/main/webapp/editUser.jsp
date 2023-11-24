<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="edit.user" method="post">
		Uesrname:<input type="text" name="username" value=${sessionScope.user.getUsername() }><br>
		Password:<input type="text" name="password" value=${sessionScope.user.getPassword() }><br>
		PhoneNumber:<input type="text" name="phone" value=${sessionScope.user.getPhoneNumber() }><br>
		Email:<input type="text" name="email" value=${sessionScope.user.getEmail() }><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
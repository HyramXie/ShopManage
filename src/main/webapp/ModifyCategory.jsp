<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>ModifyCategory</title>
    <link rel="stylesheet" href="./css/Update.css">
    <script type="text/javascript">
    if(window.name != "noReload"){
        window.name = "noReload";
        location.reload();
    } else {
        window.name = "";
    }
    </script>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>CategoryName</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${sessionScope.categories}" var="cate" >
        		<tr>
                	<td>${cate.getCategoryName()}</td>
                	<td><a href="${pageContext.request.contextPath}/UpdateCategory.jsp?id=${cate.getCategoryID()}&name=${cate.getCategoryName()}">Update</a></td>
                	<td><a href="${pageContext.request.contextPath}/DeleteCategory?id=${cate.getCategoryID()}">Delete</a></td>
           		</tr>
            </c:forEach>
        </tbody>
    </table>
    <a class="back" href="${pageContext.request.contextPath}/Manage.jsp">Back</a>
</body>
</html>

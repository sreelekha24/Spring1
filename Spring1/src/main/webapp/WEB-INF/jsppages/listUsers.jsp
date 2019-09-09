<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>
	<div align="center">
		<h1>User List</h1>

		<table border="1">
			<th>Id</th>
			<th>UserName</th>
			<th>Contact</th>
			<th>Role</th>
			<th>Email</th>

			<c:forEach var="user" items="${listUser}">
				<tr>
					<td>${user.userId }
					<td>${user.userName}</td>
					<td>${user.contact}</td>
					<td>${user.role }</td>
					<td>${user.email}</td>
					

				</tr>
			</c:forEach>
			<h3>
				<a href="newUser">Add user</a>
			</h3>
		</table>
	</div>
</body>


</html>
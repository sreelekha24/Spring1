<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.errormsg {
	color: red;
}
</style>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include><br><br>

	<div align="center">
		<form:form action="saveUser" method="post" modelAttribute="user">
			<table>
				<tr>
					<td><form:hidden path="userId" /></td>
				</tr>
				<tr>
					<td>UserName:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
					<td><small><form:errors path="password"
								cssClass="errormsg" /></small></td>
				</tr>
				<tr>
					<td>Contact:</td>
					<td><form:input path="contact" /></td>
					<td><small><form:errors path="contact"
								cssClass="errormsg" /></small></td>
				</tr>
				<tr>
					<td><form:radiobutton path="role" value="admin" /> Admin <form:radiobutton
							path="role" value="user" /> User</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
					<td><small><form:errors path="email"
								cssClass="errormsg" /></small></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" /></td>
				</tr>

			</table>
		</form:form>
	</div>
</body>
</html>
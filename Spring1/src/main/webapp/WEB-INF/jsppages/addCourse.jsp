<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include><br><br>
	<div align="center">
		<form:form action="addCourseDetails" method="post" modelAttribute="addcourse" enctype="multipart/form-data">
			<table>
				<tr>
					<td><form:hidden path="sId" /></td>
				</tr>
				<tr>
					<td>CourseName:</td>
					<td><form:input path="courseName" /></td>
				</tr>
				<tr>
					<td>Category:</td>
				</tr>
				<tr>

					<td><form:radiobutton path="category" value="Adobe" /> Adobe
						<form:radiobutton path="category" value="Hybris" /> Hybris
						<form:radiobutton path="category" value="Java" /> Java
						<form:radiobutton path="category" value="Spring" /> Spring
						<form:radiobutton path="category" value="Hibernate" /> Hibernate
						<form:radiobutton path="category" value="FrontEndTechnologies" /> FET</td>
				</tr>
				<tr>
					<td>Upload image:</td>
					<td><input id="pickUpFileAttachment" type="file"
						name="attachFileObj" size="60" /></td>
				</tr>
				<tr>
					<td>Upload File:</td>
					<td><input id="pickUpFileAttachment1" type="file"
						name="attachFileObj1" size="60" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Upload" /></td>
				</tr>

			</table>
		</form:form>
	</div>

</body>
</html>
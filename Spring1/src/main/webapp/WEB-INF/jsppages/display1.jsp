<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="main.jsp"></jsp:include><br><br>

	<table border="1">
		<th>SNO.</th>
		<th>TOPICS</th>
		<th>DESCRIPTION</th>
		<th>TASKS</th>
		<th>DAYS</th>
		<th>REFERENCES</th>

		<c:forEach items="${list}" var="list">
			<tr>
				<td><c:out value="${list.sno}"></c:out></td>
				<td><c:out value="${list.topics}"></c:out></td>
				<td><c:out value="${list.description}"></c:out></td>
				<td><c:out value="${list.tasks}"></c:out></td>
				<td><c:out value="${list.days}"></c:out></td>
				<td><c:out value="${list.reference}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
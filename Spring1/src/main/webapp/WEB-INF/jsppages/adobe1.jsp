<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>

<%@ page import="java.io.*"%>
<%@ page trimDirectiveWhitespaces="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.data {
	width: 33.33%;
	height: 10%;
}
</style>
</head>
<body>
	<jsp:include page="main.jsp"></jsp:include><br>
	<br>

	<c:forEach items="${listCourses}" var="list">
		<div class="data">
			<img src="data:image/jpg;base64,${list.base64}" height="100"
				width="150" /><br> <a
				href="${pageContext.request.contextPath}/details1/${list.courseName}">${list.courseName}</a><br>

		</div>

	</c:forEach>

</body>
</html>

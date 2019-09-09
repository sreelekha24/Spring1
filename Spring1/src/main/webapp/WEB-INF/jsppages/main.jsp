<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #d14a3b;
}

li {
	float: left;
	font-size: 20px;
}

li a:hover {
	background-color: #111;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.active {
	background-color: #d14a3b;
}
</style>
</head>
<body>
	<div class="active">

		<ul>
			<li><a href="listCourses">Courses</a></li>
			<li><a href="newUser">Registration</a></li>
			<li><a href="">Login</a></li>

		</ul>
	</div>
</body>
</html>



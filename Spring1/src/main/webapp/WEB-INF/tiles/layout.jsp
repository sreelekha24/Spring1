<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div
		style="width: 100%; height: 20%; top: 0; background-color: #e6ecf5; display:fixed;">
		<tiles:insertAttribute name="header" />
	</div>
	<div
		style="padding: 10px; width: 100%; height: 78%; display: inline-block;">
		<tiles:insertAttribute name="body" />
	</div>
	<div
		style="width: 100%; height: 2%; bottom: 0; background-color: yellow; color: black; text-align: center; display: fixed;">
		<tiles:insertAttribute name="footer" />
	</div>

</body>
</html>
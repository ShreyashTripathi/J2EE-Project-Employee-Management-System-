<!-- *Taking the choice of Register or Login
     *Redirecting to RegisterLoginController -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register or login further...</title>
</head>
<body style="background-color: #90A4AE;">
	<h1 style="text-align: center; color: #ffffff">Register or Login to Proceed further..</h1>
	<form action="RegisterLoginController" method="get">
		<jsp:include page="RegisterLogin.html"></jsp:include>
	</form>
</body>
</html>
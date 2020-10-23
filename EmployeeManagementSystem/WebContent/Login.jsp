<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #90A4AE;">

	<%
		response.setContentType("text/html");
		if (request.getAttribute("message") != null) {
			out.print(
					"<h3 style='text-align: center; color: #ffffff'>" + request.getAttribute("message") + "</h3>");
		}
	%>


	<h1 style="text-align: center; color: #ffffff">Login Page</h1>
	<div align="center"
		style="padding: 40px; height: 80%; background-color: #62757F;">
		<form action="LoginController" method="get">
			<div align="center">
				<span style="color: #ffffff; font-style: italic; font-size: 20px">UserId:
				</span><input
					style="border:none;border-radius: 4px; background-color: #1C313A; font-size: 20px; color: #ffffff; font-style: italic; width: 80%; padding: 12px 20px; margin: 8px 0; box-sizing: border-box;"
					type="text" name="userId" /> <br /> <span
					style="color: #ffffff; font-style: italic; font-size: 20px">Password:</span>
				<input
					style="border:none;border-radius: 4px; background-color: #1C313A; font-size: 20px; color: #ffffff; font-style: italic; width: 80%; padding: 12px 20px; margin: 8px 0; box-sizing: border-box;"
					type="text" name="passWord" /> <br /> <input type="submit"
					value="Login"
					style="margin-top: 120px; background-color: #1C313A; border-radius: 4px; border: none; color: white; padding: 16px 32px; text-decoration: none; margin: 4px 2px; cursor: pointer;" />
			</div>
		</form>
	</div>
	<div align="center"
		style="margin-top:50px;padding: 40px; height: 80%; background-color: #62757F;">
		<form action="Home.html" method="get">

			<input type="submit" value="Register" style="margin-top: 120px; background-color: #1C313A; border-radius: 4px; border: none; color: white; padding: 16px 32px; text-decoration: none; margin: 4px 2px; cursor: pointer;" />

		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- *Registration first Page
     *Displaying the message if any-->
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

			String message = (String) request.getAttribute("message");
			out.print("<h3 style='text-align: center; color: #ffffff'>" + message + "</h3>");

		}
	%>
	<h1 style="text-align: center; color: #ffffff">Enter your Personal
		Details</h1>
	<div align="center"
		style="padding: 40px; height: 300px; background-color: #62757F;">
		<form action="RegisterController" method="post">
			<span style="color: #ffffff; font-style: italic; font-size: 20px">Employee Name:</span> <input type="text" name="employeeName" style="border:none;border-radius:4px;background-color:#1C313A;font-size:20px;color:#ffffff;font-style:italic;width:80%;padding: 12px 20px; margin: 8px 0; box-sizing: border-box;" /><br />
			<span style="color: #ffffff; font-style: italic; font-size: 20px">Father's Name:</span> <input type="text" name="fatherName" style="border:none;border-radius:4px;background-color:#1C313A;font-size:20px;color:#ffffff;font-style:italic;width:80%;padding: 12px 20px; margin: 8px 0; box-sizing: border-box;" /><br /> 
			<span style="color: #ffffff; font-style: italic; font-size: 20px">Gender:</span><br />
			<span style="color: #ffffff; font-style: italic; font-size: 20px">Male:</span><input type="radio" name="gender" value="male"><br /> 
			<span style="color: #ffffff; font-style: italic; font-size: 20px">Female:</span><input type="radio" name="gender" value="female"><br /> 
			<span style="color: #ffffff; font-style: italic; font-size: 20px">Date of Birth:</span> <input type="text" name="dateOfBirth" style="border:none;border-radius:4px;background-color:#1C313A;font-size:20px;color:#ffffff;font-style:italic;width:80%;padding: 12px 20px; margin: 8px 0; box-sizing: border-box;" /><br /> 
			<input type="submit" value="Proceed to next Registration Page" style="margin-top: 120px; background-color: #1C313A; border-radius: 4px; border: none; color: white; padding: 16px 32px; text-decoration: none; margin: 4px 2px; cursor: pointer;" />
		</form>
	</div>
</body>
</html>
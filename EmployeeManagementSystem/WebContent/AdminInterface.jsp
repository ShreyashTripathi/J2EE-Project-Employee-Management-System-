<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Reply_emp" %>
<%@ page import="java.util.List" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body style="background-color: #90A4AE;">
<%
   response.setContentType("text/html");
   if(request.getAttribute("message")!=null){
	   out.print("<h3  style='text-align: center; color: #ffffff'>"+request.getAttribute("message")+"</h3>");
   }
   
   if(request.getAttribute("table")!=null){
	   List<Reply_emp> ls = (List<Reply_emp>)request.getAttribute("table");
	   out.print("<table>");
		for (Reply_emp obj : ls) {
			out.print("<tr>");
			out.print("<th  style='text-align: center; color: #ffffff'>"+obj.getDepartment()+"</th>");
			out.print("<td  style='text-align: center; color: #ffffff'>"+obj.getMsg()+"</td>");
			out.print("<tr>");
			
		}
		out.print("</table>");
   }
%>
   <div align="center"
		style="padding: 40px; height:80%; background-color: #62757F;">
	<form action="AdminController" method="post">
		<h4  style="text-align: center; color: #ffffff">Select the department in which you have to send the Consignment</h4>
		<select name="adminDept" style="width: 100%; padding: 16px 20px; border: none; border-radius: 4px; background-color: #1C313A; color: #ffffff">
			<option value="development">DEVELOPMENT</option>
			<option value="marketing">MARKETING</option>
			<option value="testing">TESTING</option>
			<option value="recruitment">RECRUITMENT</option>
		</select>
		<br/>
		<textarea name="consignment" style="border:none;border-radius:4px;background-color:#1C313A;font-size:20px;color:#ffffff;font-style:italic;width:90%;padding: 12px 20px; margin: 8px 0; box-sizing: border-box;" rows="6" cols="100"></textarea><br/>
		<input type="submit" value="Pass the consignment.." style="margin-top: 120px; background-color: #1C313A; border-radius: 4px; border: none; color: white; padding: 16px 32px; text-decoration: none; margin: 4px 2px; cursor: pointer;" >
	</form>
	</div>
	<%@ include file="LogOut.jsp" %>
</body>
</html>
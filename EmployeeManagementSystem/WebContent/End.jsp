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
     if(request.getAttribute("message")!=null){
    	 out.print("<h3 style='text-align: center; color: #ffffff'>"+request.getAttribute("message")+"</h3>");
     }
   %>
   <%@ include file="LogOut.jsp" %>
</body>
</html>
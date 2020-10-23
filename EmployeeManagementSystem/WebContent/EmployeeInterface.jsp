<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Development_emp"%>
<%@ page import="model.Marketing_emp"%>
<%@ page import="model.Testing_emp"%>
<%@ page import="model.Recruitment_emp"%>
<%@ page import="java.io.IOException"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #90A4AE;">
	<%!private void myCastEmp(Object obj, String dpt, JspWriter out) throws IOException {
		if (dpt.equals("development")) {

			Development_emp object = (Development_emp) obj;
			out.print("<tr>");
			out.print("<th style='text-align: center; color: #ffffff'>" + object.getId() + "</th>");
			out.print("<td style='text-align: center; color: #ffffff'>" + object.getMsg() + "</td>");
			out.print("</tr>");

		} else if (dpt.equals("marketing")) {

			Marketing_emp object = (Marketing_emp) obj;
			out.print("<tr>");
			out.print("<th style='text-align: center; color: #ffffff'>" + object.getId() + "</th>");
			out.print("<td style='text-align: center; color: #ffffff'>" + object.getMsg() + "</td>");
			out.print("</tr>");
		} else if (dpt.equals("testing")) {

			Testing_emp object = (Testing_emp) obj;
			out.print("<tr>");
			out.print("<th style='text-align: center; color: #ffffff'>" + object.getId() + "</th>");
			out.print("<td style='text-align: center; color: #ffffff'>" + object.getMsg() + "</td>");
			out.print("</tr>");

		} else if (dpt.equals("recruitment")) {

			Recruitment_emp object = (Recruitment_emp) obj;
			out.print("<tr>");
			out.print("<th style='text-align: center; color: #ffffff'>" + object.getId() + "</th>");
			out.print("<td style='text-align: center; color: #ffffff'>" + object.getMsg() + "</td>");
			out.print("</tr>");

		}
	}%>
	<%
		response.setContentType("text/html");
		if (request.getAttribute("resultMessage") != null) {
			out.print("<h2 style='text-align: center; color: #ffffff'>" + request.getAttribute("resultMessage") + "</h2>");
		}
		if (request.getAttribute("message") != null) {
			out.print("<h3 style='text-align: center; color: #ffffff'>" + request.getAttribute("message") + "</h3>");
		}

		if (request.getAttribute("list") != null) {

			List<Object> list = (List<Object>) request.getAttribute("list");
			User user = (User) request.getAttribute("user");
			if (list.isEmpty()) {
				String message = "No New Consignments for your department.";
				request.setAttribute("message", message);
				request.getRequestDispatcher("End.jsp").forward(request, response);
			} else {
				out.print("<table>");
				try {
					for (Object obj : list) {
						myCastEmp(obj, user.getDepartment(), out);
					}
				} catch (Exception e) {
					out.print(e.getMessage());
				}
				out.print("</table>");
			}

			session.setAttribute("result", list);
		}
	%>
	<div align="center" 
		style="margin-top:30px;padding: 40px; height:80%; background-color: #62757F;">
	<form action="ReplyController" method="post">
		<h4 style="text-align: center; color: #ffffff">ANY REPLY YOU WANT TO GIVE REGARDING THE CONSIGNMENTS..</h4>
		<textarea name="reply" style="border:none;border-radius:4px;background-color:#1C313A;font-size:20px;color:#ffffff;font-style:italic;width:90%;padding: 12px 20px; margin: 8px 0; box-sizing: border-box;" rows="4" cols="100"></textarea>
		<input type="submit" value="Pass your reply to the Admin.." style="margin-top: 120px; background-color: #1C313A; border-radius: 4px; border: none; color: white; padding: 16px 32px; text-decoration: none; margin: 4px 2px; cursor: pointer;" />
	</form>
	</div>
	<%@ include file="LogOut.jsp"%>
</body>
</html>
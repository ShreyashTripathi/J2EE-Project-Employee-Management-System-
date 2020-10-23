<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Development_head"%>
<%@ page import="model.Marketing_head"%>
<%@ page import="model.Testing_head"%>
<%@ page import="model.Recruitment_head"%>
<%@ page import="java.io.IOException"%>
<%@ page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department head page</title>
</head>
<body  style="background-color: #90A4AE;">

	<%!public void myCast(Object obj, String dpt, JspWriter out) throws IOException {

		if (dpt.equals("development")) {

			Development_head object = (Development_head) obj;
			out.print("<tr>");
			out.print("<th style='text-align: center; color: #ffffff'>" + object.getId() + "</th>");
			out.print("<td style='text-align: center; color: #ffffff'>" + object.getMsg() + "</td>");
			out.print("</tr>");

		} else if (dpt.equals("marketing")) {

			Marketing_head object = (Marketing_head) obj;
			out.print("<tr>");
			out.print("<th style='text-align: center; color: #ffffff'>" + object.getId() + "</th>");
			out.print("<td style='text-align: center; color: #ffffff'>" + object.getMsg() + "</td>");
			out.print("</tr>");
		} else if (dpt.equals("testing")) {

			Testing_head object = (Testing_head) obj;
			out.print("<tr>");
			out.print("<th style='text-align: center; color: #ffffff'>" + object.getId() + "</th>");
			out.print("<td style='text-align: center; color: #ffffff'>" + object.getMsg() + "</td>");
			out.print("</tr>");

		} else if (dpt.equals("recruitment")) {

			Recruitment_head object = (Recruitment_head) obj;
			out.print("<tr>");
			out.print("<th style='text-align: center; color: #ffffff'>" + object.getId() + "</th>");
			out.print("<td style='text-align: center; color: #ffffff'>" + object.getMsg() + "</td>");
			out.print("</tr>");

		}

	}%>
	<%
		response.setContentType("text/html");
		if (request.getAttribute("message") != null) {
			out.print("<h3 style='text-align: center; color: #ffffff'>" + request.getAttribute("message") + "</h3>");
		}

		if (request.getAttribute("list") != null) {

			List<Object> list = (List<Object>) request.getAttribute("list");
			if (list.isEmpty()) {
				String message = "No New Consignments for your department.";
				request.setAttribute("message", message);
				request.getRequestDispatcher("End.jsp").forward(request, response);

			} else {
				User user = (User) request.getAttribute("user");
				out.print("<table>");
				try {

					for (Object obj : list) {
						myCast(obj, user.getDepartment(), out);
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
	<form action="DpHeadController" method="post">
		<input type="submit" style="margin-top: 120px; background-color: #1C313A; border-radius: 4px; border: none; color: white; padding: 16px 32px; text-decoration: none; margin: 4px 2px; cursor: pointer;" value="Pass the consignments to the respective employees..">
	</form>
	</div>
	<%@ include file="LogOut.jsp"%>
</body>
</html>
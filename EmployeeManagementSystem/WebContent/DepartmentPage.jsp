<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>   
<%@ page import="java.sql.Connection" %>
<%@ page import="model.User" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter the department</title>
</head>
<body style="background-color: #90A4AE;">
    <h1 style="text-align: center; color: #ffffff">Select the department..</h1>
    <div align="center"
		style="padding: 40px; height:80%; background-color: #62757F;"><form action="" method="get">
      <select name="setDept" style="width: 100%; padding: 16px 20px; border: none; border-radius: 4px; background-color: #1C313A; color: #ffffff">
       <option value="development">DEVELOPMENT</option>
       <option value="marketing">MARKETING</option>
       <option value="testing">TESTING</option>
       <option value="recruitment">RECRUITMENT</option>
      
      </select>
      
      <input type="submit" name="submitDept" value="Submit_Department" style="margin-top: 120px; background-color: #1C313A; border-radius: 4px; border: none; color: white; padding: 16px 32px; text-decoration: none; margin: 4px 2px; cursor: pointer;"/>
    </form>
    </div>
    <%@ include file="LogOut.jsp" %>
</body>
</html>
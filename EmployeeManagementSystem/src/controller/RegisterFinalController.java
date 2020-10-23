package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BusinessException;
import model.User;
import registerBao.RegisterBaoImp;
import registerBao.RegisterBaoInt;

/**
 * Servlet implementation class RegisterFinalController
 */
@WebServlet("/RegisterFinalController")
public class RegisterFinalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterFinalController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * 
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * If session id null then redirecting to Register.jsp. 
		 * Taking the final details of the page into the User Object.
		 
		 */
		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
		if (session == null) {

			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			// response.getWriter().print("<h1>"+"Please submit this form please"+"</h1>");
			String message = "Please submit this form please";
			request.setAttribute("message", message);
			rd.forward(request, response);
		} else {
			User user = (User) session.getAttribute("user");
			user.setContactNo(request.getParameter("contactNo"));
			user.setEmail(request.getParameter("email"));
			user.setAddress1(request.getParameter("address1"));
			user.setAddress2(request.getParameter("address2"));
			user.setCity(request.getParameter("city"));
			user.setPostalCode(request.getParameter("postalCode"));
			user.setUserId(request.getParameter("userId"));
			user.setPassWord(request.getParameter("passWord"));
			
			PrintWriter out = response.getWriter();
			// Register user to the database and invalidate the session..
			try {
				RegisterBaoInt register = new RegisterBaoImp();
				register.registerUser(user);
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				out.print("<h1>" + "User Registered" + "</h1>");
				rd.include(request, response);
			} catch (BusinessException e) {
				RequestDispatcher rd = request.getRequestDispatcher("Register.html");
				out.print("<h1>" + e.getMessage() + "</h1>");
				rd.include(request, response);
			} finally {
				session.removeAttribute("user");
				session.invalidate();
			}
		}

	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterLoginController
 */
@WebServlet("/RegisterLoginController")
public class RegisterLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Redirecting to login.jsp or Register.jsp accordingly */
		String choice = request.getParameter("loginRegister");
		if (choice != null && choice.equals("login")) {
			response.sendRedirect("Login.jsp");
		} else if (choice != null && choice.equals("register")) {

			response.sendRedirect("Register.jsp");
		}
	}

}

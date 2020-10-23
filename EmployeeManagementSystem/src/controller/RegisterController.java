package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Creating a new HttpSession and storing the Regsitration first page details
		 * and storing the details into the User object.
		 */
		HttpSession session = request.getSession();
		User user = new User();
		user.setEmployeeName(request.getParameter("employeeName"));
		user.setFatherName(request.getParameter("fatherName"));
		user.setGender(request.getParameter("gender"));
		user.setDateOfBirth(request.getParameter("dateOfBirth"));
		session.setAttribute("user", user);
		response.sendRedirect("RegisterSecondPage.html");
	}

}

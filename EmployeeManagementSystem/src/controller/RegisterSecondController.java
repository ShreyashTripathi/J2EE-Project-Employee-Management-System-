package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class RegisterSecondController
 */
@WebServlet("/RegisterSecondController")
public class RegisterSecondController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterSecondController() {
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
		 * If Session is null then displaying the message and redirecting to
		 * Register.jsp(Registration first page) Storing the Registration second page
		   details into the user object into the session
		 *Redirecting to the RegisterThirdPage.html
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
			user.setCollegeName(request.getParameter("collegeName"));
			user.setExperience(request.getParameter("experience"));
			user.setPrevSalary(request.getParameter("prevSalary"));
			user.setSpecialization(request.getParameter("specialization"));
			Cookie cookies[] = request.getCookies();
			
			user.setDesignation(cookies[0].getValue());
			session.setAttribute("user", user);
			response.sendRedirect("RegisterThirdPage.html");
		}

	}

}

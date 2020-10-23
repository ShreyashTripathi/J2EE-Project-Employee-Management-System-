package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.GetConnection;
import exception.BusinessException;
import loginBao.LoginBaoImp;
import loginBao.LoginBaoInt;
import model.ConnectionDetails;
import model.Dep_head;
import model.Employee;
import model.MyTable;
import model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	User currentUser;
	MyTable mytable;

	private void closeConnection(Transaction transaction, Session session, SessionFactory factory) {
		transaction.commit();
		session.close();
		factory.close();
	}

	void afterUpdate(PrintWriter out, HttpServletRequest request, HttpServletResponse response)
			throws BusinessException {
		response.setContentType("text/html");
		String dept = request.getParameter("setDept");
		currentUser.setDepartment(dept);
		String tableName = mytable.getTableName();

		ConnectionDetails connection = null;
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		connection = GetConnection.getConnection();

		factory = connection.getFactory();
		session = connection.getSession();
		transaction = connection.getTransaction();

		if (tableName.equals("Dep_head")) {
			Dep_head dep_head = new Dep_head();
			dep_head.setUserId(currentUser.getUserId());
			dep_head.setDepartment(dept);
			session.save(dep_head);
		} else if (tableName.equals("Employee")) {
			Employee employee = new Employee();
			employee.setUserId(currentUser.getUserId());
			employee.setDepartment(dept);
			session.save(employee);
		}
		closeConnection(transaction, session, factory);

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String message = null;
		if (request.getParameter("setDept") != null) {

			try {

				afterUpdate(out, request, response);
			} catch (BusinessException e) {
				message = e.getMessage();
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");

				rd.forward(request, response);
			}
			request.setAttribute("currentUser", currentUser);
			request.getRequestDispatcher("LoginForward").forward(request, response);

		} else {
			String userId = request.getParameter("userId");
			String passWord = request.getParameter("passWord");

			currentUser = new User();
			mytable = new MyTable();
			currentUser.setUserId(userId);
			currentUser.setPassWord(passWord);

			LoginBaoInt login = new LoginBaoImp();

			try {
				login.loginUser(currentUser, request, response, mytable);
				request.setAttribute("currentUser", currentUser);
				request.getRequestDispatcher("LoginForward").forward(request, response);
			} catch (BusinessException e) {
				message = e.getMessage();
				request.setAttribute("message",message);
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);

			}
		}

	}

}

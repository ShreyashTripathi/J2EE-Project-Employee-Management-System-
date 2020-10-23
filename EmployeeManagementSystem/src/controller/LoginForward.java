package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dpBao.DpBaoImp;
import dpBao.DpBaoInt;
import exception.BusinessException;
import model.Development_emp;
import model.Development_head;
import model.Marketing_emp;
import model.Marketing_head;
import model.Recruitment_emp;
import model.Recruitment_head;
import model.Reply_emp;
import model.Testing_emp;
import model.Testing_head;
import model.User;
import replyBao.ReplyBaoImp;
import replyBao.ReplyBaoInt;

/**
 * Servlet implementation class LoginForward
 */
@WebServlet("/LoginForward")
public class LoginForward extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginForward() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User) request.getAttribute("currentUser");
		session.setAttribute("currentLoginUser", user);

		if (user != null && user.getDesignation().equals("Admin")) {

			ReplyBaoInt reply = new ReplyBaoImp();

			try {

				List<Reply_emp> ls = reply.viewReply();

				//System.out.println("ls "+ls);
				request.setAttribute("table", ls);

			} catch (BusinessException e) {
				String message = e.getMessage();
				request.setAttribute("message", message);
			}finally {
				request.getRequestDispatcher("AdminInterface.jsp").forward(request, response);
			}

		} else if (user != null && user.getDesignation().equals("DepartmentHead")) {
			DpBaoInt getMsg = new DpBaoImp();
			try {
				List list = getMsg.showMsg(user.getDepartment());

				request.setAttribute("list",list);
				request.setAttribute("user",user);
				

			} catch (BusinessException e) {
				request.setAttribute("message",e.getMessage());
				
			}finally {
				request.getRequestDispatcher("DepartmentHeadInterface.jsp").forward(request, response);
			}


		} else if (user != null && user.getDesignation().equals("Employee")) {
			DpBaoInt getMsg = new DpBaoImp();
			
			try {
				List<Object> ls = getMsg.showMsgEmp(user.getDepartment());

				request.setAttribute("list",ls);
				request.setAttribute("user",user);
				

			} catch (BusinessException e) {
				request.setAttribute("message",e.getMessage());
				
			}finally {
				request.getRequestDispatcher("EmployeeInterface.jsp").forward(request, response);
			}
			
		}
	}

	

	

}

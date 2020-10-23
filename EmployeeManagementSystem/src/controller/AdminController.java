package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminBao.AdminBaoImp;
import adminBao.AdminBaoInt;
import exception.BusinessException;
import model.Reply_emp;
import replyBao.ReplyBaoImp;
import replyBao.ReplyBaoInt;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
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
		
		String dept = request.getParameter("adminDept");
		String msg = request.getParameter("consignment");

		AdminBaoInt send = new AdminBaoImp();
		String message = null;
		ReplyBaoInt reply = new ReplyBaoImp();
		List<Reply_emp> ls = null;
		try {
			send.sendMessage(dept, msg);
			ls = reply.viewReply();
			// out.print("<h1>"+"Message has been sent Successfully"+"</h1>");
			message = "Message has been sent Successfully";

		} catch (BusinessException e) {
			message = e.getMessage();
		}
		request.setAttribute("table", ls);
		request.setAttribute("message", message);
		request.getRequestDispatcher("AdminInterface.jsp").forward(request, response);

	}

}

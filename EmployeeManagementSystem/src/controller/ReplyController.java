package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BusinessException;
import model.User;
import replyBao.ReplyBaoImp;
import replyBao.ReplyBaoInt;

/**
 * Servlet implementation class ReplyController
 */
@WebServlet("/ReplyController")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentLoginUser");
		ReplyBaoInt reply = new ReplyBaoImp();
		String message = null;
		try {
			reply.insertReply(user.getDepartment(), request.getParameter("reply"));
		    message = "Your precious reply has been recorded..";
		} catch (BusinessException e) {
			message = e.getMessage();
		}finally {
			request.setAttribute("resultMessage",message);
		    request.setAttribute("currentUser",user);
			request.getRequestDispatcher("LoginForward").forward(request,response);
		}
		
		
		
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dpBao.DpBaoImp;
import dpBao.DpBaoInt;
import exception.BusinessException;
import model.User;

/**
 * Servlet implementation class DpHeadController
 */
@WebServlet("/DpHeadController")
public class DpHeadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DpHeadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		User currentUser = (User)session.getAttribute("currentLoginUser");
		List<Object> result = (List<Object>) session.getAttribute("result");
		DpBaoInt db = new DpBaoImp();
		String message = null;
		try {
			db.passMsg(currentUser.getDepartment(),result);
			message = "Messages passed to the employees";
		} catch (BusinessException e) {
			message = e.getMessage();
		}
		
		request.setAttribute("message",message);
		request.getRequestDispatcher("End.jsp").forward(request,response);
	}

}

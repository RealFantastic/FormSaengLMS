package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.asg.model.dao.AsgListDao;
import kh.semi.lms.asg.model.service.AsgListService;

/**
 * Servlet implementation class PfAsgCommentDeleteServlet
 */
@WebServlet("/pf/asgboard/read/delete.ax")
public class PfAsgCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		   TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("cNo");
		int cNo = Integer.parseInt(no);
		
		System.out.println(cNo);
		
		int result = new AsgListService().deleteComment(cNo);
		
		PrintWriter out = response.getWriter();
		
		if(result <= 0) {
			out.print(0);
			out.flush();
			out.close();
			return;
		} else {
			out.print(result);
			out.flush();
			out.close();
		}
		
		
		
	}

}

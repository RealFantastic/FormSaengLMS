package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.asg.model.service.AsgListService;

/**
 * Servlet implementation class PfAsgListDeleteServlet
 */
@WebServlet("/pflmsasgboard/delete.ax")
public class PfAsgListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgListDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost/delete");
		
		String[] delNo = request.getParameterValues("chk");
		System.out.println(delNo[0]);
		
		int result = new AsgListService().multiDeleteBoard(delNo);
		
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

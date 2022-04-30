package kh.semi.lms.professor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.asg.model.service.AsgListService;
import kh.semi.lms.asg.model.vo.AsgListVo;

/**
 * Servlet implementation class PfAsgListReadServlet
 */
@WebServlet("/pfreadasg")
public class PfAsgListReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgListReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bANoStr = request.getParameter("bANo");
				
		int bANo = Integer.parseInt(bANoStr);
		
		System.out.println(bANo);
		AsgListVo readBoard = new AsgListService().readBoard(bANo);

		if(readBoard != null) {
			request.setAttribute("readBoard", readBoard);
			request.getRequestDispatcher("WEB-INF/view/professor/pf_readasgboard.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

}

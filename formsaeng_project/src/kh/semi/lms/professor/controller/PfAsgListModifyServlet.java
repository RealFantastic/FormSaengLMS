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
 * Servlet implementation class PfAsgListModifyServlet
 */
@WebServlet("/pf/asgboard/modify")
public class PfAsgListModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgListModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String no = request.getParameter("bANo");
//		String page = request.getParameter("page"); //todo - 페이지넘버 가져와서 원래 있던 페이지로 go back.
		
		int bANo = Integer.parseInt(no);
		System.out.println("넘어 왔어? bano야 : " + bANo);
		
		AsgListVo vo = new AsgListService().readBoard(bANo);
		request.setAttribute("ssAsgListVo", vo);
//		request.setAttribute("pageNum", pageNum); // todo - 페이지 처리
		
		request.getRequestDispatcher("/WEB-INF/view/professor/pf_modifyasgboard.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	

}

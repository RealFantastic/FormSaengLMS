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
 * Servlet implementation class PfAsgListModifyDoServlet
 */
@WebServlet("/asgmodifydo")
public class PfAsgListModifyDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgListModifyDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		 String bANoStr = request.getParameter("bANo");
		 System.out.println("banostr ? : " + bANoStr);
		System.out.println("title ? : " + title);
		System.out.println("content ? : " + content);
		 int bANo = Integer.parseInt(bANoStr);
		AsgListVo vo = new AsgListVo();
		vo.setbATitle(title);
		vo.setbAContent(content);
		vo.setbANo(bANo);
		int result = new AsgListService().updateBoard(vo);
		if(result < 1) {
			System.out.println("글수정 실패");
			request.getSession().setAttribute("msg", "글수정 실패");
			response.sendRedirect("board/asgmodify?bANo="+bANo);
//			request.getRequestDispatcher("/WEB-INF/view/professor/pf_modifyasgboard.jsp").forward(request, response);
		} else {
			System.out.println("글수정 성공");
			request.getSession().setAttribute("msg", "글수정 성공");
			response.sendRedirect("pfreadasg?bANo="+bANo);
		}
	}

}

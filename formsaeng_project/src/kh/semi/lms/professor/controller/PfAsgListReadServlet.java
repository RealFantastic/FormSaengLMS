package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.asg.model.service.AsgListService;
import kh.semi.lms.asg.model.vo.AsgCommentVo;
import kh.semi.lms.asg.model.vo.AsgListVo;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class PfAsgListReadServlet
 */
@WebServlet("/pf/asgboard/read")
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
		
		// 넘어온 값 가져오기
		String cContent = request.getParameter("content");

		System.out.println("bANoStr : " + bANoStr);
		System.out.println("cContent : " + cContent);

		// 세션정보 가져오기
		MemberVo vo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		String name = vo.getName();
		String id = vo.getId();
				
		AsgCommentVo avo = new AsgCommentVo();
		avo.setcWriter(name);
		avo.setbANo(bANo);
		avo.setcContent(cContent);
		avo.setId(id);
		
		AsgListVo readBoard = new AsgListService().readBoard(bANo);
		ArrayList<AsgCommentVo> commentList = new AsgListService().readBoardAndComments(avo);
		
		System.out.println("댓글 있냐? : " + commentList);
		request.setAttribute("commentList", commentList);
		
//		ArrayList<AsgCommentVo> readBoardAndComments = new AsgListService().readBoardAndComments(avo);

		
		if(readBoard != null) {
			request.setAttribute("readBoard", readBoard);
			request.getRequestDispatcher("/WEB-INF/view/professor/pf_readasgboard.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

}

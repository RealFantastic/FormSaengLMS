package kh.semi.lms.professor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.asg.model.service.AsgListService;
import kh.semi.lms.asg.model.vo.AsgListVo;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class PfAsgListInsertDoServlet
 */
@WebServlet("/pf/asgboard/insert.do")
public class PfAsgListInsertDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgListInsertDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		MemberVo mvo = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		String writer = "아무개";
		String content = request.getParameter("content");
		
		AsgListVo vo = new AsgListVo(); 
		vo.setbATitle(title);
		vo.setbAWriter(writer);
		vo.setbAContent(content);
		
		int result = new AsgListService().insertBoard(vo);
		
		System.out.println("result :"+result);
		
		if(result < 1) {
			System.out.println("글등록 실패");
			request.getSession().setAttribute("emsg","글등록 실패");
			response.sendRedirect(request.getContextPath()+"/pf/asgboard/insert");
		} else {
			request.getSession().setAttribute("emsg", "글등록 성공");
			request.setAttribute("inf", vo);
			response.sendRedirect(request.getContextPath()+"/pf/asgboard");
		}
	}

}

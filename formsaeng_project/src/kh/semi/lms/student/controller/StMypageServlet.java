package kh.semi.lms.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.member.model.service.MemberService;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class StMypageServlet
 */
@WebServlet("/stmypage")
public class StMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StMypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get: /stMyPage");
		
		MemberVo ss = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		String id = ss.getId();
		String pwd = ss.getPwd();
		MemberVo vo = new MemberVo(id, pwd);
		vo.setId(id);
		vo.setPwd(pwd);
		
		MemberVo result = new MemberService().readMember(vo);
		System.out.println(vo);
		
		try {
		if(result == null) {
		response.sendRedirect("stmain");
	}	else {
		request.setAttribute("MyPageVo", result);
		request.getRequestDispatcher("/WEB-INF/view/student/stMyPage.jsp").forward(request, response);
	}
		}catch(Exception e){
		e.printStackTrace();
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

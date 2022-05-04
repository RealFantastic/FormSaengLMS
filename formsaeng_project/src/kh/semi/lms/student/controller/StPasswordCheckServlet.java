package kh.semi.lms.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.member.model.service.MemberService;
import kh.semi.member.model.vo.MemberVo;

@WebServlet("/stpwdcheck.do")
public class StPasswordCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StPasswordCheckServlet() {
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
		System.out.println("doPost: /pwdcheck.do");
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		
		String id = ssvo.getId();
		String pwdcheck = request.getParameter("pwdcheck");
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPwd(pwdcheck);
		
		PrintWriter out = response.getWriter();
		
		MemberVo result = new MemberService().login(vo);
		
		
		if(result == null) { // 비번 틀림
			out.print("실패");
			System.out.println("비밀번호 틀림.");
		}else { // 비번 일치
			System.out.println("비밀번호 일치.");
			out.print("성공");
		}

		out.flush();
		out.close();
		
	}

}

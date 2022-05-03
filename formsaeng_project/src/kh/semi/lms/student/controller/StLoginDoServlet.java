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

/**
 * Servlet implementation class StLoginDoServlet
 */
@WebServlet("/stlogin.do")
public class StLoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StLoginDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost: /stlogin.do");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberVo vo = new MemberVo(id, pwd);
		vo.setId(id);
		vo.setPwd(pwd);
		
		MemberVo result = new MemberService().login(vo);
		PrintWriter out = response.getWriter();
		if(result == null) { // 학번 또는 비번 틀림
			out.print("실패");
			System.out.println("로그인에 실패했습니다.");
		}else { // 로그인 성공
			System.out.println("로그인 성공!!!!! 세션 ssMemberVo 저장 : " + vo);
			out.print("성공");
			request.getSession().setAttribute("ssMemberVo", vo); // 로그인 유지
		}

		out.flush();
		out.close();
		
	}

}

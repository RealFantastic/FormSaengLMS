package kh.semi.lms.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.member.model.service.MemberService;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class MgMainServlet
 */
@WebServlet("/mglogin.do")
public class MgLoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgLoginDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberVo vo = new MemberVo(id, pwd);
		vo.setId(id);
		vo.setPwd(pwd);
		
		MemberVo result = new MemberService().login(vo);
		if(result == null) {
			request.getSession().setAttribute("msg", "사번 혹은 비밀번호를 다시 확인해주세요");
			response.sendRedirect("mglogin"); //로그인 실패시 다시 입력 처음으로 돌아가기
			System.out.println("로그인에 실패했습니다.");
		}else {
			System.out.println("로그인에 성공했습니다.");
			//TODO session 등록
			request.getSession().setAttribute("msg", vo.getName()+"님 반갑습니다"); // 로그인 성공 메시지
			request.getSession().setAttribute("ssMemberVo", vo); // 로그인 유지
			response.sendRedirect("mgmain"); // 메인 페이지로 이동
		}
		
		
		
	}

}

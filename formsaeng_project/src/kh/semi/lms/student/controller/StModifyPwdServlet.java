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
 * Servlet implementation class StModifyPwdServlet
 */
@WebServlet("/st/modifypwd.do")
public class StModifyPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StModifyPwdServlet() {
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
		System.out.println("do get: /stmodifypwd");
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMemberVo");

		MemberVo vo = new MemberVo();
		vo.setId(ssvo.getId());
		vo.setPwd(ssvo.getPwd());
		
		
		
		PrintWriter out = response.getWriter();
		
		String newpwd = request.getParameter("newpwd");
		System.out.println(newpwd);
		

		vo.setPwd(newpwd);
		int result = new MemberService().updatePwd(vo);
		if (result > 0) {
			System.out.println("수정 성공");
			out.print("성공");
			System.out.println(vo);
			ssvo.setPwd(newpwd); // 세션에 비번 변경해주기
			out.flush();
			out.close();
		} else {
			out.print("실패");
			System.out.println("수정 실패");
			System.out.println(vo);
		}
		
		
	}
		
		
		
	}



package kh.semi.lms.student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kh.semi.member.model.service.MemberService;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class StModifyDoServlet
 */
@WebServlet("/st/mypagem.do")
public class StModifyDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StModifyDoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션 불러오기
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMemberVo");

		MemberVo vo = new MemberVo();
		vo.setId(ssvo.getId());
		vo.setPwd(ssvo.getPwd());

		PrintWriter out = response.getWriter();


		String pnum = request.getParameter("pnum");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		System.out.println(email);
		System.out.println(pnum);
		System.out.println(address);

		
		// 연락처 수정
		if(pnum != null ) {
		vo.setPnum(pnum);
		int result = new MemberService().updatePnum(vo);
		if (result > 0) {
			System.out.println("수정 성공");
			out.print("성공");
			System.out.println(vo);
			out.flush();
			out.close();
			return;
		} else {
			out.print("실패");
			System.out.println("수정 실패");
			System.out.println(vo);
			return;
		}
		} else if (address != null) {
		
		// 주소 수정
		vo.setAddress(address);
		int resulta = new MemberService().updateAddress(vo);
		if (resulta > 0) {
			System.out.println("수정 성공");
			out.print("성공");
			System.out.println(vo);
			out.flush();
			out.close();
			return;
		} else {
			out.print("실패");
			System.out.println("수정 실패");
			System.out.println(vo);
			return;
		}
		} else if(email != null) {
		// 이메일 수정
		vo.setEmail(email);
		int resulte = new MemberService().updateEmail(vo);
		if (resulte > 0) {
			System.out.println("수정 성공");
			out.print("성공");
			System.out.println(vo);
			out.flush();
			out.close();
			return;
		} else {
			out.print("실패");
			System.out.println("수정 실패");
			System.out.println(vo);
			
		}

	}
	}
}

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
@WebServlet("/stmypagem.do")
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
		// 기존의 생성된 세션과 세션에 담겨있던 “member” 객체를 불러온다.
		MemberVo ssvo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		
		MemberVo vo = new MemberVo();
		vo.setId(ssvo.getId());
		vo.setPwd(ssvo.getPwd());
		
		
		PrintWriter out = response.getWriter();
		
		
		 String pnum1 = request.getParameter("pnum1");
		 String pnum2 = request.getParameter("pnum2");
		 String pnum3 = request.getParameter("pnum3");
		 String email = request.getParameter("email");
		 String address = request.getParameter("address");
		 String detailAddress = request.getParameter("detailAddress");
		 String extraAddress = request.getParameter("extraAddress");
	
		 vo.setPnum(pnum1+"-"+pnum2+"-"+pnum3);
		 vo.setEmail(email+"@gmail.com");
		 vo.setAddress(address+""+detailAddress+""+extraAddress);
		 
		 int result = new MemberService().updateMember(vo);

		 System.out.println(vo);
		 
		 if(result > 0) {
		 System.out.println("수정 성공");
		 out.print("성공");
		 out.flush();
		 out.close();
		 } else {
			 out.print("실패");
			 System.out.println("수정 실패");
		 }
	}
	
}


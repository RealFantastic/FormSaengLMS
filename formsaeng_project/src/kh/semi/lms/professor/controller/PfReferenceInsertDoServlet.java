package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.reference.service.ReferenceService;
import kh.semi.lms.reference.vo.ReferenceVo;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class PfReferenceInsertDoServlet
 */
@WebServlet("/pf/refinsert.do")
public class PfReferenceInsertDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfReferenceInsertDoServlet() {
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
System.out.println("ref");
		
		MemberVo vo2 = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		
		String name = vo2.getName();
		String subjectCode = request.getParameter("code");
		System.out.println("subjectCode"+subjectCode);
		String lbAtitle=request.getParameter("title");
		String lbAcontent=request.getParameter("content");
		
		ReferenceVo vo=new ReferenceVo();
		vo.setLbATitle(lbAtitle);
		vo.setLbAContent(lbAcontent);
		
		int result=new ReferenceService().insertReferenceBoard(vo, name,subjectCode);
		
		PrintWriter out= response.getWriter();
		if(result==0) {
			System.out.println("실패했습니다 리스트페이지로 돌아갑니다");
			out.print(0);
			out.flush();
			out.close();
		}else {
			System.out.println("성공");
			out.print(1);
			out.flush();
			out.close();
		}
	}

}

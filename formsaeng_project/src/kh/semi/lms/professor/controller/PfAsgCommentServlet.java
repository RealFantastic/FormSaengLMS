package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.asg.model.service.AsgListService;
import kh.semi.lms.asg.model.vo.AsgCommentVo;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class PfAsgCommentServlet
 */
@WebServlet("/pf/asgboard/read/comment")
public class PfAsgCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgCommentServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 넘어온 값 가져오기
		String bANoStr = request.getParameter("bANo");
		String cContent = request.getParameter("content");

		System.out.println("bANoStr : " + bANoStr);
		System.out.println("cContent : " + cContent);

		int bANo = Integer.parseInt(bANoStr);
		// 세션정보 가져오기
		MemberVo vo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		String name = vo.getName();
		String id = vo.getId();

		System.out.println(name);
		System.out.println(id);

		AsgCommentVo avo = new AsgCommentVo();
		avo.setcWriter(name);
		avo.setbANo(bANo);
		avo.setcContent(cContent);
		avo.setId(id);

		int result = new AsgListService().insertAsgComment(avo);

		PrintWriter out = response.getWriter();

		if (result <= 0) {
			out.print(0);
			out.flush();
			out.close();
			return;
		} else {
			out.print(result);
			out.flush();
			out.close();
		}

	}

}

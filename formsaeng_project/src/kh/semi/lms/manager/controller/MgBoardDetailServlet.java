package kh.semi.lms.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.board.model.service.MgBoardDetailService;
import kh.semi.board.model.vo.MgBoardListVo;

@WebServlet("/mgbdetail")
public class MgBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MgBoardDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet/mgnoticedetail");
		
		String nnoStr=request.getParameter("nno");

		System.out.println(nnoStr);
		
		int nno=Integer.parseInt(nnoStr);
		
		MgBoardListVo vo = new MgBoardDetailService().detailBoardView(nno);
		
		if(vo!=null) {
			request.setAttribute("detailtitle", vo.getBoardNoticeTitle());
			request.setAttribute("detailcontent", vo.getBoardNoticeContent());
			request.getRequestDispatcher("WEB-INF/view/manager/mgNoticeDetail.jsp").forward(request, response);
		}

		System.out.println(vo);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

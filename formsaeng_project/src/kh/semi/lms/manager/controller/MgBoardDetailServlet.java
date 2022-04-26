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

		String vo = new MgBoardDetailService().detailBoardView();
		System.out.println(vo);
		request.setAttribute("boarddetail", vo);
		request.getRequestDispatcher("WEB-INF/view/manager/mgNoticeDetail.jsp").forward(request, response);
	}
}

package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.board.model.service.MgBoardListService;
import kh.semi.board.model.vo.MgBoardListVo;

@WebServlet("/mgblist")
public class MgBoardListSevlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet /mgnotice");

		ArrayList<MgBoardListVo> volist = new MgBoardListService().view();
//		ArrayList<BoardVo> volist = service.listBoard(startRnum, endRnum);
		System.out.println(volist);	
		request.setAttribute("boardVolist", volist);
		request.getRequestDispatcher("WEB-INF/view/manager/mgNoticeView.jsp").forward(request, response);
	}
}


package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.notice.model.service.NoticeService;
import kh.semi.notice.model.vo.NoticeVo;

@WebServlet("/mgblist")
public class MgNoticeListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet /mgnotice");

		ArrayList<NoticeVo> volist = new NoticeService().view();
//		ArrayList<BoardVo> volist = service.listBoard(startRnum, endRnum);
		System.out.println(volist);	
		request.setAttribute("boardVolist", volist);
		request.getRequestDispatcher("WEB-INF/view/manager/mgNoticeView.jsp").forward(request, response);
	}
}

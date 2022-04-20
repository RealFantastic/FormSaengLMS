package kh.semi.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.notice.service.NoticeService;
import kh.semi.notice.vo.NoticeVo;

@WebServlet("/mgnotice.do")
public class NoticeListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet /mgnotice");
		// DB에서 board  읽어오기
//		int currentPage = 1;
//		
//		final int pageSize = 20;
//		final int pageBlock = 3;
//		int totalCnt = countBoardList();
//		
//		// paging 처리
//		int pageCnt = (totalCnt/pageSize) + (totalCnt%pageSize==0 ? 0 : 1);
//		int startPage = 1;
//		int endPage = 1;
//		if(currentPage%pageBlock == 0) {
//			startPage = ((currentPage/pageBlock)-1)*pageBlock + 1;
//		} else {
//			startPage = (currentPage/pageBlock)*pageBlock + 1;
//		}
//		endPage = startPage + pageBlock - 1;
//		if(endPage > pageCnt) {
//			endPage = pageCnt;
//		}
//		System.out.println("paging" + startPage+"~"+endPage);
//		
//		// rownum 처리
//		int startRnum = 0;
//		int endRnum = 0;
//		startRnum = (currentPage-1)*pageSize + 1;
//		endRnum = startRnum + pageSize - 1;
//		if(endRnum > totalCnt) {
//			endRnum = totalCnt;
//		}
//		
		ArrayList<NoticeVo> volist = new NoticeService().view();
//		ArrayList<BoardVo> volist = service.listBoard(startRnum, endRnum);
		System.out.println(volist);	
		request.setAttribute("boardVolist", volist);
		request.getRequestDispatcher("WEB-INF/view/notice/NoticeView.jsp").forward(request, response);
	}
}


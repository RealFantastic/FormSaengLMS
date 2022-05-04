package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.notice.model.service.NoticeService;
import kh.semi.notice.model.vo.NoticeVo;

@WebServlet("/mg/notice/list")
public class MgNoticeListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet /mgblist");

		// 페이징
		System.out.println("pageNum 값은?" + request.getParameter("pageNum"));
		String page = request.getParameter("pageNum");
		System.out.println("page 값은?" + page);
		int currentPage = 1;

		// page 값 확인
		if (page != null && !page.equals("")) {
			currentPage = Integer.parseInt(page);
		}
		System.out.println("currentPage : " + currentPage);
		final int pageSize = 5;
		final int pageBlock = 3;
		int totalCnt = countNotice();

		// paging 처리
		int pageCnt = totalCnt / pageSize + (totalCnt % pageSize == 0 ? 0 : 1);
		int startPage = 1;
		int endPage = 1;
		// int endPage=pageBlock;
		if (currentPage % pageBlock == 0) {
			startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
		} else {
			startPage = (currentPage / pageBlock) * pageBlock + 1;
		}
		endPage = startPage + pageBlock - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		System.out.println("paging : " + startPage + "~" + endPage);

//		rownum
		int startRnum = 0;
		int endRnum = 0;
		startRnum = (currentPage - 1) * pageSize + 1;
		endRnum = startRnum + pageSize - 1;
		if (endRnum > totalCnt) {
			endRnum = totalCnt;
		}

//		ArrayList<NoticeVo> volist = new NoticeService().view(); // 페이징 처리 전에 사용
		ArrayList<NoticeVo> volist = new NoticeService().view(startRnum, endRnum);
		System.out.println("servlet volist : " + volist);

		request.setAttribute("boardVolist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCnt", pageCnt);

		request.getRequestDispatcher("WEB-INF/view/manager/mgNoticeView.jsp").forward(request, response);
	}

	public int countNotice() {
		int result = new NoticeService().countNotice();
		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

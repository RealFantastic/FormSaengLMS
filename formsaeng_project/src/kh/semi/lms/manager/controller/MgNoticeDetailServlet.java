package kh.semi.lms.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.notice.model.service.NoticeService;
import kh.semi.notice.model.vo.NoticeVo;

@WebServlet("/mg/notice/detail")
public class MgNoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MgNoticeDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet/mgnoticedetail");
		
		String nnoStr=request.getParameter("nno");

		System.out.println(nnoStr);
		
		int nno=Integer.parseInt(nnoStr);
		
		NoticeVo vo = new NoticeService().detailBoardView(nno);
		//가따온거 쿼리문 돌린내용이 들어있음
		
		if(vo!=null) {
			request.setAttribute("detailtitle", vo.getBoardNoticeTitle());
			request.setAttribute("detailcontent", vo.getBoardNoticeContent());
			request.setAttribute("ssnoticeVo", vo); //SSnoticeVo에 vo를 저장했음
			request.getRequestDispatcher("/WEB-INF/view/manager/mgNoticeDetail.jsp").forward(request, response);
		}

		System.out.println(vo);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

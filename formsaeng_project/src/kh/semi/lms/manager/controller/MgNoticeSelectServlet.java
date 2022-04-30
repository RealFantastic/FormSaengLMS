package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.notice.model.service.NoticeService;
import kh.semi.notice.model.vo.NoticeVo;

/**
 * Servlet implementation class MgNoticeSelectSevlet
 */
@WebServlet("/MgNoticeSelectSevlet")
public class MgNoticeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgNoticeSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<NoticeVo> listNotice = null;
		String searchCondition=request.getParameter("searchCondition");
		String searchValue=request.getParameter("searchValue");
		
//		listNotice=new NoticeService().selectNotice();
		if(searchCondition != null && searchValue !=null) {
			// 검색 한 결과
			listNotice =new NoticeService().selectNotice(searchCondition, searchValue);
		}else {
			// 검색 안 한 결과
			listNotice=new NoticeService().selectNotice();
		}
		
		if(listNotice != null) {
			request.setAttribute("listNotice", listNotice);
			request.getRequestDispatcher("WEB-INF/view/manager/mgNoticeView.jsp").forward(request, response);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

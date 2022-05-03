package kh.semi.lms.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.notice.model.service.NoticeService;
import kh.semi.notice.model.vo.NoticeVo;

/**
 * Servlet implementation class MgNoticeChange
 */
@WebServlet("/mgbupdate")
public class MgNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//href로 넘어오면 doGet
		String nnoStr=request.getParameter("nno");
//		mgNoticeUpdate.jsp에서 (nno)번호를 가져온걸 nnostr에 담아준다. 항상 string으로 가져온다 .int인지 알 수 없다. 

		System.out.println("nnoStr"+nnoStr);

		int nno=Integer.parseInt(nnoStr);
//		nnoStr를 int형으로 변경하여 int형 nno에 넣어준다.

		System.out.println("nno 서블릿 : "+nno);

		NoticeVo vo=new NoticeService().detailBoardView(nno);
		//NoticeService.detailBoardView에 있는걸 NoticeVo vo호출

		request.setAttribute("ddvo", vo);

		request.getRequestDispatcher("/WEB-INF/view/manager/mgNoticeUpdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

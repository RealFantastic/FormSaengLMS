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
//		업데이트 jsp에서 번호를 가져온걸 nnostr에 담아준다. 항상 string으로 가져온다 .int인지 알 수 없다. 
		String nnoStr=request.getParameter("nno");
		System.out.println("nnoStr"+nnoStr);
//		인트형으로 변경
		int nno=Integer.parseInt(nnoStr);
		//확인용
		System.out.println("nno 서블릿 : "+nno);
		//서비스 딜테일보드뷰에 있는걸 vo에 호출
		NoticeVo vo=new NoticeService().detailBoardView(nno);
		
		request.setAttribute("ddvo", vo);

		request.getRequestDispatcher("/WEB-INF/view/manager/mgNoticeUpdate.jsp").forward(request, response);
		
	}

	//href로 넘어오면 doGet
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

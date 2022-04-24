package kh.semi.lms.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.board.model.service.MgBoardEnrollService;
import kh.semi.board.model.vo.MgBoardListVo;

/**
 * Servlet implementation class MgBoardEnrollServlet
 */
@WebServlet("/mgbinsert")
public class MgBoardEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgBoardEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("doGet/mgnoticeenroll");
		
		request.getRequestDispatcher("WEB-INF/view/manager/mgNoticeEnroll.jsp").forward(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기 들어오는지 확인용");
		
		
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		MgBoardListVo vo=new MgBoardListVo();
		vo.setBoardNoticeTitle(title);
		vo.setBoardNoticeContent(content);
		System.out.println("controller vo : " + vo);
		
		int result=new MgBoardEnrollService().insertBoard(vo);
		
		System.out.println("controller result : "+result);
		
		if(result==0) {
			System.out.println("글쓰기 실패ㅠㅠㅠㅠㅠㅠㅠㅠㅠ");
		}else {
			System.out.println("글쓰기 성공!!!!");
			response.sendRedirect("mgblist");
		}
		
		
		
		
//		doGet(request, response);
	}

}

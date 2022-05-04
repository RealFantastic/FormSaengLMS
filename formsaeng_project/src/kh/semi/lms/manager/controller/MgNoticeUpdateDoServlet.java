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
 * Servlet implementation class MgNoticeUpdateDoServlet
 */
@WebServlet("/mg/notice/update.do")
public class MgNoticeUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgNoticeUpdateDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost들어옴");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String bNnoStr=request.getParameter("bNno");
//		System.out.println(title);
//		System.out.println(content);
//		System.out.println(bNno);
		
		int bNno=Integer.parseInt(bNnoStr);
		
		NoticeVo vo=new NoticeVo();
		vo.setBoardNoticeTitle(title);
		vo.setBoardNoticeContent(content);
		vo.setBoardNoticeNo(bNno);
		
		int result= new NoticeService().updateBoard(vo);
		System.out.println(vo);
		
		if(result<1) {
			System.out.println("글 수정 실패ㅠㅠㅠㅠ");
			response.sendRedirect(request.getContextPath()+"/mg/notice/detail?bNno="+bNno);
		}else {
			System.out.println("글 수정 완료");
			response.sendRedirect(request.getContextPath()+"/mg/notice/detail?nno="+bNno);
			}
		
		
	}

}

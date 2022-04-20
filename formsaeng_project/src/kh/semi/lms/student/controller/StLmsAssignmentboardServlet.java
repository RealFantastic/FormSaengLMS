package kh.semi.lms.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.board.model.service.BoardService;
import kh.semi.board.model.vo.BoardVo;

/**
 * Servlet implementation class StLmsAssignmentboardSevlet
 */
@WebServlet("/StLmsAssignmentboard")
public class StLmsAssignmentboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StLmsAssignmentboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget /boardlist");
		// DB에서 board list의 데이터를 읽어와야함.
		
			int currentPage = 1;
			final int pageSize = 12;
			final int pageBlock = 3;
			int totalCnt = countListBoard();
			
			//paging 처리
			int pageCnt = totalCnt/pageSize + (totalCnt%pageSize==0? 0: 1);
			int startPage = 1;
			int endPage = pageBlock;
			if(currentPage%pageBlock == 0) {			
			startPage = ((currentPage/pageBlock)-1)*pageBlock + 1;
			} else {
				startPage = (currentPage/pageBlock)*pageBlock + 1;
			}
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCnt) {
				endPage = pageCnt;
			}
			System.out.println("paging"+ startPage +"~"+endPage);
			
			//*rownum*
			int startRnum = 0;
			int endRnum = 0;
			startRnum =  (currentPage-1)*pageSize+1;
			endRnum = startRnum + pageSize - 1;
			if(endRnum > totalCnt) {
				endRnum = totalCnt;
			}
			ArrayList<BoardVo> volist = new BoardService().AssignmentBoardlist(startRnum,endRnum);
			System.out.println(volist);
		
			request.setAttribute("boardVolist", volist);
			request.getRequestDispatcher("WEB-INF/view/board/boardlist.jsp").forward(request, response);
	}
	
	public int countListBoard() {
		int result = new BoardService().countListBoard();
		return result;
	}
	
	public BoardVo readBoardAndComment(int bNo) {
		BoardVo result = new BoardService().readBoardAndComment(bNo);
		return result;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

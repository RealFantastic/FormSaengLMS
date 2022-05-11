package kh.semi.lms.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.reference.service.ReferenceService;
import kh.semi.lms.reference.vo.ReferenceVo;

/**
 * Servlet implementation class stReferenceListServlet
 */
@WebServlet("/st/reflist")
public class StReferenceListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StReferenceListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget / 강의자료실");
		// DB에서 StLmsAssignmentboard list의 데이터를 읽어와야함.
		
			System.out.println("pageNum 값은?"+request.getParameter("pageNum"));			
			String page = request.getParameter("pageNum");
			String subcode = request.getParameter("s");
			System.out.println("page 값은?"+page); 
			int currentPage = 1;
			
			// 값이 null인지 판단하여 int형으로 변환
			if(page != null && !page.equals("")) {
				currentPage = Integer.parseInt(page);
			}
			System.out.println("currentPage : " + currentPage);
			final int pageSize = 5;
			final int pageBlock = 3;
			int totalCnt = countListBoard();
			
			//paging 처리
			int pageCnt = totalCnt/pageSize + (totalCnt%pageSize==0? 0: 1);
			int startPage = 1;
			int endPage = 1;
			// int endPage = pageBlock;
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
			ArrayList<ReferenceVo> volist = new ReferenceService().ReferenceBoardlist(startRnum, endRnum, subcode);
			System.out.println(volist);
		
			request.setAttribute("boardVolist", volist);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("pageCnt", pageCnt);
			request.setAttribute("s", subcode);
			
			request.getRequestDispatcher("/WEB-INF/view/student/stReferenceList.jsp").forward(request, response);
	}

	public int countListBoard() {
		int result = new ReferenceService().countListBoard();
		return result;
	}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}



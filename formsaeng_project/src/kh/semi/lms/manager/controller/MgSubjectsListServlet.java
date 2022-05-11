package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.subject.model.service.SubjectService;
import kh.semi.subject.model.vo.SubjectVo;

/**
 * Servlet implementation class MgSubjectInsertServlet
 */
@WebServlet("/mg/Subjects")
public class MgSubjectsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgSubjectsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /mg/Subjects");
		
		String pageNum = request.getParameter("p");
		String searchType = request.getParameter("search_type");
		String searchWord = request.getParameter("search_word");
		
		System.out.println(searchType);
		System.out.println(searchWord);
		
		System.out.println();
		//검색조건이 전달되지 않았을 경우 기본 검색조건, 검색어
		String searchType_ = "dept_name";
		if(searchType == null) {
			//기본으로 학과명이 선택되도록함.
			searchType= searchType_;
		}
		String searchWord_ = "";
		if(searchWord == null) {
			searchWord = searchWord_;
		}
		
		System.out.println("null 변환 이후 : " +searchType);
		System.out.println("null 변환 이후 : " +searchWord);
		
		System.out.println("pageNum : " + pageNum);
		
		int currentPage = 1;
		
		if(pageNum != null && !pageNum.equals("")) {
			currentPage = Integer.parseInt(pageNum);
		}
		
		final int pageSize = 5;	// 한 페이지당 보여질 게시물의 갯수 : 3개
		final int pageBlock = 3;  // 1,2,3 블럭>> 4,5,6 블럭 >> ....

		int totalCnt = 0; //과목의 총 갯수
		if(searchType == null || searchWord == null) {
			//검색 결과가 없을 때
			totalCnt = new SubjectService().countMgSubject();
		}else {
			totalCnt = new SubjectService().countMgSubject(searchType,searchWord);
		}
		
		//paging처리!!!
		//총 페이지 수 = 전체 게시글 수 / 페이지당 보여질 게시글 수 + (나눈 나머지가 있으면 +1 페이지,없으면 +0)
		int pageCnt = totalCnt / pageSize + (totalCnt % pageSize==0 ? 0 : 1);
		int startPage = 1; //
		int endPage = 1;
		
		//시작 페이지블럭 함수
		if(currentPage % pageBlock == 0) {
			//현재페이지 % 페이지 블럭수가 0일 떄
			//((현제페이지 / 페이지 블럭수)-1) * 페이지 블럭수 + 1
			startPage = ((currentPage / pageBlock) -1) * pageBlock + 1;
		}else {			
		//현재페이지 % 페이지 블럭수가 0이 아닐 떄
		//((현제페이지 / 페이지 블럭수) * 페이지 블럭수 + 1
			startPage = (currentPage / pageBlock) * pageBlock + 1;
		}
		//끝나는 페이지블럭 함수
		endPage = startPage + pageBlock -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		
		System.out.println("paging " + startPage + " ~ " + endPage);
		
//		rownum 처리(rownum을 쿼리문의 인자로 넘겨 
//		페이지당 표시될 게시물을 가져옴)
		int startRnum = 0;	//시작번호
		int endRnum = 0;	//끝번호
		
		//rownum 시작번호 함수
		//시작페이지 = (현재 페이지 -1) * 페이지당 보여질 게시물 수 + 1
		startRnum = (currentPage -1) * pageSize + 1;
		//rownum 끝번호 함수
		//끝번호 = 시작번호 + 페이지당 보여질 게시물 수 -1
		endRnum = startRnum + pageSize -1;
		// 끝번호 > 전체 게시물 수(예시에선 20) => 끝번호 = 전체 게시물 수(예시에선 20)
		if(endRnum > totalCnt) {
			endRnum = totalCnt;
		}
		
		ArrayList<SubjectVo> result = new SubjectService().mgSubjectList(startRnum,endRnum,searchType,searchWord);
		System.out.println("서블릿으로 돌아온 result : " + result);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchWord", searchWord);
		request.setAttribute("subList", result);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCnt", pageCnt);
		request.getRequestDispatcher("/WEB-INF/view/manager/mgSubjectsList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

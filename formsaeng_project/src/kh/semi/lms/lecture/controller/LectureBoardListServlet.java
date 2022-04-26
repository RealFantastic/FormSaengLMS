package kh.semi.lms.lecture.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.lecture.board.service.LectureBoardService;
import kh.semi.lms.lectureboard.vo.LectureBoardVo;

/**
 * Servlet implementation class LectureBoardListSerlvet
 */
@WebServlet("/lecblist")
public class LectureBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LectureBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LectureBoardVo> volist = null;
//		ArrayList<BoardVo> volist = service.listBoard(startRnum, endRnum);
		
		volist = new LectureBoardService().LectureBoardlist();
		System.out.println(volist);	
		request.setAttribute("lectureVolist", volist);
		request.getRequestDispatcher("WEB-INF/view/notice/NoticeView.jsp").forward(request, response);
	}

}

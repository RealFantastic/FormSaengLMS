package kh.semi.lms.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.lecture.model.service.LectureService;
import kh.semi.lms.lecture.model.vo.LectureVo;

/**
 * Servlet implementation class StWeekListServlet
 */
@WebServlet("/st/week")
public class StWeekListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StWeekListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_id = request.getParameter("id"); 
		String user_subCode = request.getParameter("subCode");
		//값받아오면 넘겨주기
		
		String id = "S2022954112";
		String subCode = "C0101";
		
		ArrayList<LectureVo> volist = new LectureService().lectureBoardList(id, subCode);
		
		/*
		 * String[] numArray = new String[]
		 * {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
		 * "Eleven","Tweleve","Thirteen","Fourteen","Fifteen"};
		 */
		
		for(int i = 0; i<volist.size(); i++) {
			int no = volist.get(i).getWeekNo(); 
			String num = Integer.toString(no).substring(2,4);
			String cName = "";
			
			switch(num) {
				case "01" : cName = "One"; break;
				case "02" : cName = "Two"; break;
				case "03" : cName = "Three"; break;
				case "04" : cName = "four"; break;
				case "05" : cName = "Five"; break;
				case "06" : cName = "Six"; break;
				case "07" : cName = "Seven"; break;
				case "08" : cName = "Eight"; break;
				case "09" : cName = "Nine"; break;
				case "10" : cName = "Ten"; break;
				case "11" : cName = "Eleven"; break;
				case "12" : cName = "Tweleve"; break;
				case "13" : cName = "Thirteen"; break;
				case "14" : cName = "Fourteen"; break;
				case "15" : cName = "Fifteen"; break;
				default : break;
			};
			
			volist.get(i).setcName(cName);
			String fileName = "\\";
			fileName += volist.get(i).getfName();
			volist.get(i).setfName(fileName);
			
		}
		
		request.setAttribute("lectureVolist", volist);
		request.getRequestDispatcher("/WEB-INF/view/student/st_lectureboardlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

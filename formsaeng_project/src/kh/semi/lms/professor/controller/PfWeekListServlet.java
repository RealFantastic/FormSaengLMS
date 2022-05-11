package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;

import kh.semi.lms.lecture.model.service.LectureService;
import kh.semi.lms.lecture.model.vo.LectureVo;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class PfWeekListServlet
 */
@WebServlet("/pf/week")
public class PfWeekListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfWeekListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MemberVo vo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		String user_id = vo.getId();
		String user_subCode = request.getParameter("s");
		String user_subName = request.getParameter("n");
		
		ArrayList<LectureVo> volist = new ArrayList();
		if(user_id.charAt(0) == 'P') {
			volist = new LectureService().lectureBoardListP(user_id, user_subCode);
		}else {
			volist = new LectureService().lectureBoardListS(user_id, user_subCode);
		}
		
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
		request.setAttribute("subName",user_subName);
		request.setAttribute("subCode", user_subCode);
		request.getRequestDispatcher("/WEB-INF/view/professor/pf_lectureboardlsit.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

}

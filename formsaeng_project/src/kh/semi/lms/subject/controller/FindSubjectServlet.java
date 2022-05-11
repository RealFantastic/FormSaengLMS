package kh.semi.lms.subject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.semi.lms.enrolment.model.service.EnrolmentService;
import kh.semi.member.model.vo.MemberVo;
import kh.semi.subject.model.service.SubjectService;
import kh.semi.subject.model.vo.SubjectVo;

/**
 * Servlet implementation class FindSubjectServlet
 */
@WebServlet("/subMenu.ax")
public class FindSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /subMenu.ax");
		MemberVo mvo = (MemberVo) request.getSession().getAttribute("ssMemberVo");
		
		ArrayList<SubjectVo> result = null;
		
		
		String userId = mvo.getId();
		System.out.println(userId.charAt(0));
		if(userId.charAt(0) == 'P') {
			 result = new SubjectService().teachList(mvo);
		}else if(userId.charAt(0) == 'S') {
			 result = new EnrolmentService().appliedList(mvo);
		}
		
				
		PrintWriter out = response.getWriter();
		
		if(result == null) {
			out.print(0);
			out.flush();
			out.close();
			return;
		}else {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String jsonResult = gson.toJson(result);
			System.out.println(jsonResult);
			
			out.print(jsonResult);
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

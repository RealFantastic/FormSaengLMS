package kh.semi.lms.manager.controller;

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

import kh.semi.member.model.service.MemberService;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class SelectProfessorServlet
 */
@WebServlet("/selectPf.ajx")
public class SelectProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProfessorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /selectPf.ajx");
		String deptCode="";
		try {
			 deptCode = request.getParameter("department");			
		}catch(Exception e) {
			System.out.println("여기서 뻗음");
		}
		System.out.println("view에서 넘어온 학과코드 : " + deptCode);
		
		MemberVo vo = new MemberVo();
		vo.setDeptCode(deptCode);
		
		ArrayList<MemberVo> pfList = new MemberService().selectPf(vo);
		
		System.out.println("db를 거쳐 서블릿에 돌아온 값 : " + pfList);
		
		
		Gson gobj = new GsonBuilder().setPrettyPrinting().create();
		
		String pfJson = gobj.toJson(pfList);
		PrintWriter out = response.getWriter();
		System.out.println("json으로 변환한 값 : " + pfJson);
		
		out.print(pfJson);
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

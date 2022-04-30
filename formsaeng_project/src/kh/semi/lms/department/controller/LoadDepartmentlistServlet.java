package kh.semi.lms.department.controller;

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

import kh.semi.lms.department.model.vo.DepartmentVo;
import kh.semi.subject.model.service.SubjectService;

/**
 * Servlet implementation class LoadDepartmentlistServlet
 */
@WebServlet("/deptLoad.ajx")
public class LoadDepartmentlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadDepartmentlistServlet() {
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
		System.out.println("doPost : /deptLoad.ajx");
		PrintWriter out = response.getWriter();
		
		ArrayList<DepartmentVo> deptlist = new SubjectService().selectDept();
		
		System.out.println("서블릿으로 돌아온 소속목록" + deptlist);
		
		Gson gobj = new GsonBuilder().setPrettyPrinting().create();
		
		String deptJson = gobj.toJson(deptlist);
		System.out.println("json형태로 변환한 값 : "+deptJson);
		out.print(deptJson);
		out.flush();
		out.close();
	}

}

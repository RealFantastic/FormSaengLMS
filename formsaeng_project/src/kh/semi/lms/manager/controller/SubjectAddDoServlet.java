package kh.semi.lms.manager.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.subject.model.service.SubjectService;
import kh.semi.subject.model.vo.SubjectVo;

/**
 * Servlet implementation class SubjectAddDoServlet
 */
@WebServlet("/addSubject.ajx")
public class SubjectAddDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectAddDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost : /addSubject.ajx");
		System.out.println(request.getParameter("a"));
//		BufferedReader reader = request.getReader();
//		
//		System.out.println("parameter로 읽은 값 : " + request.getParameter("queryString"));
//		System.out.println("reader로 읽은 값 : " + reader.readLine());
		String department = request.getParameter("department");
		String subjectName = request.getParameter("subjectName");
		String subjectCode = request.getParameter("subjectCode");
		String grade = request.getParameter("grade");
		String semester = request.getParameter("semester");
		String credit = request.getParameter("credit");
		String classroom = request.getParameter("classroom");
		String capacity = request.getParameter("capacity");
		String classType = request.getParameter("classType");
		String classDate = request.getParameter("classDate");
		String periods[] = request.getParameterValues("period");
		String period="";
		for(int i=0; i<periods.length; i++) {
			period += periods[i] + ",";
		}
		period = period.substring(0, period.length()-1);
		String professor = request.getParameter("professor");
		System.out.println("department : " + department);
		System.out.println("subjectName : " +subjectName);
		System.out.println(subjectCode);
		System.out.println("grade : " + grade);
		System.out.println("semester : " + semester);
		System.out.println("credit : " + credit);
		System.out.println("classroom : " + classroom);
		System.out.println("capacity : " + capacity);
		System.out.println("classType : " + classType);
		System.out.println("classDate : " + classDate);
		System.out.println("period : " + period);
		System.out.println("professor : " + professor);
		
		


//		System.out.println(semester);
//		System.out.println(periods);
		//여기 구현...
		SubjectVo svo = new SubjectVo();
		//TODO 화면에서 넘어온 값 svo에 넣는다.
		svo.setDeptCode(department);
		svo.setSubName(subjectName);
		svo.setSubCode(subjectCode);
		svo.setCourseGrade(Integer.parseInt(grade));
		svo.setCourseSemester(Integer.parseInt(semester));
		svo.setCourseCredit(Integer.parseInt(credit));
		svo.setCourseClass(classroom);
		svo.setCourseCapacity(Integer.parseInt(capacity));
		if(classType.equals("1")) {
			classType = "전공필수";
		}else if(classType.equals("0")) {
			classType = "전공선택";
		}
		System.out.println("변환한 classType : " + classType);
		svo.setClassType(classType);
		svo.setCourseDay(classDate);
		svo.setCoursePeriod(period);
		svo.setPfName(professor);
		
		int result = new SubjectService().insertSubject(svo);
		PrintWriter out = response.getWriter();
		if(result <= 0) {
			out.print(0);// 입력 실패
			out.flush();
			out.close();
			System.out.println("과목추가 실패");
			return;
		}else if(result > 0) {
			out.print(1);
			out.flush();
			out.close();
			System.out.println("과목추가 성공");
		}
		
		
		
		
		
		
		
		
		
	}

}

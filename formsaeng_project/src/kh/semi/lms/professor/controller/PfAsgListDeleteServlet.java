package kh.semi.lms.professor.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.asg.model.service.AsgListService;

/**
 * Servlet implementation class PfAsgListDeleteServlet
 */
@WebServlet("/pflmsasgboard/delete.ax")
public class PfAsgListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgListDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		PrintWriter out = response.getWriter();
		
		String[] param1 = request.getParameterValues("id");
		System.out.println( param1[0] );
	
//		for(int i=0; i<param1.length; i++) {
//			System.out.println(param1[i]);
//		}
		
		for(int i=0; i<param1.length; i++) {
		 	if(i<param1.length-1) {
			param1[i] += ","; 	
		 	}
		}
		
		
		int result = new AsgListService().multiDeleteBoard(param1);
		
		
		/* System.out.println(param1); */
		
		out.print(param1+"전달받았습니다.");
		out.print("응답합니다.");
		
		out.flush();
		out.close();
		
		if(result<1) {
			System.out.println("삭제에 실패했습니다.");
		} else {
			System.out.println("삭제에 성공했습니다.");
		}
		
		
		
	}

}

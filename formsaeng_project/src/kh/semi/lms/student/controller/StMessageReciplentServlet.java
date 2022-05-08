package kh.semi.lms.student.controller;

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

import kh.semi.member.model.vo.MemberVo;
import kh.semi.message.model.service.MessageService;

/**
 * Servlet implementation class StMessageReciplentServlet
 */
@WebServlet("/st/reciplent.ax")
public class StMessageReciplentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StMessageReciplentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("잘넘어왔니??"+request.getParameter("name")); 
		
		String reqName=request.getParameter("name");
		
		ArrayList<MemberVo> reciplent=new MessageService().reciplent(reqName);
		System.out.println("doGet : " +reciplent);

		Gson gson=new GsonBuilder().setPrettyPrinting().create();//syso으로 확인하기 편함
		String gs =gson.toJson(reciplent);
		System.out.println("gson : "+gs);
		
		PrintWriter out =response.getWriter();
		if(gs==null) {
			out.print(0);
			out.flush();// 버퍼 비워주고
			out.close();// 버퍼 닫아주고
		}else {
			out.print(gs);
			out.flush();// 버퍼 비워주고
			out.close();// 버퍼 닫아주고
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

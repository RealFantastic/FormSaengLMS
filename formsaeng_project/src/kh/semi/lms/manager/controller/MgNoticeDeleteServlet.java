package kh.semi.lms.manager.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kh.semi.notice.model.service.NoticeService;

/**
 * Servlet implementation class MgNoticeDeleteServlet
 */
@WebServlet("/mg/delete.ax")
public class MgNoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgNoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
//		버퍼리더 호출
		String reqData = br.readLine();
//		화면에서 받아온 값을 버퍼리더를 통해서 변수에 담음
		Gson gson = new Gson();
//		gson 라이브러리 호출
		ArrayList<Integer> nolist= gson.fromJson(reqData.toString(), new TypeToken<ArrayList<Integer>>(){}.getType());
//		json데이터를 gson라이브러리 사용해서 arraylist로 바꾼다. TypeToken<ArrayList<Integer>> => 제네릭
		int[] dellist = nolist.stream().mapToInt(Integer::intValue).toArray();
//		nolist를 배열타입으로 바꿈
		System.out.println("reqData :"+nolist.toString());
		
		int cnt = new NoticeService().deleteBoard(dellist);
//		int형 cnt에 NoticeService에 deleteBoard 결과값을 저장한다.
		if(cnt > 0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
//			화면에 뿌려주는 객체 = PrintWriter 짝꿍getWriter
			out.print("succeess");
			out.flush(); //비워준다.
			out.close(); //PrintWriter 닫아준다.
		}
	}

}

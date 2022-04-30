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
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import kh.semi.notice.model.service.NoticeService;

/**
 * Servlet implementation class MgNoticeDeleteServlet
 */
@WebServlet("/delete.ax")
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
		// TODO Auto-generated method stub
		BufferedReader br = request.getReader();
		String reqData = br.readLine();
		
		Gson gson = new Gson();
		ArrayList<Integer> nolist= gson.fromJson(reqData.toString(), new TypeToken<ArrayList<Integer>>(){}.getType());
		int[] dellist = nolist.stream().mapToInt(Integer::intValue).toArray();
		System.out.println("reqData :"+nolist.toString());
		int cnt = new NoticeService().deleteBoard(dellist);
		
		if(cnt > 0) {

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("succeess");
			out.flush();		
		}
		doGet(request, response);
	}

}

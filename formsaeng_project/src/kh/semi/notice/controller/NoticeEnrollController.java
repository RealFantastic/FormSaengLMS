package kh.semi.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mgnoticeenroll")
public class NoticeEnrollController extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("doGet/mgnoticeenroll");
		
		request.getRequestDispatcher("WEB-INF/view/notice/NoticeEnroll.jsp").forward(request,response);
	}
}

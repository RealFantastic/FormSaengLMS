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

import kh.semi.notice.model.service.NoticeService;
import kh.semi.notice.model.vo.NoticeVo;

/**
 * Servlet implementation class MgNoticeSelectSevlet
 */
@WebServlet("/notice/select")
public class NoticeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<NoticeVo> listNotice = null;
		String ff=request.getParameter("ff");
		String qq=request.getParameter("qq");
		System.out.println("ff : " + ff);
		System.out.println("qq : " + qq);
		
		if(ff != null && qq !=null) {
			// 검색 한 결과
			listNotice =new NoticeService().selectNotice(ff, qq);
			System.out.println("서블릿에 돌아온 listNotice : " + listNotice);
			
			PrintWriter out = response.getWriter();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String result = gson.toJson(listNotice);
			if(result == "") {
				
				out.print(result);
				out.flush();
				out.close();
			}else {
				System.out.println(result);
				out.print(result);
				out.flush();
				out.close();
			}
			
		}
//		
//		if(listNotice != null) {
//			request.setAttribute("listNotice", listNotice);
//			request.getRequestDispatcher("WEB-INF/view/manager/mgNoticeView.jsp").forward(request, response);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

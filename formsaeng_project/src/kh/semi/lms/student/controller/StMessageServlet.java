package kh.semi.lms.student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.member.model.vo.MemberVo;
import kh.semi.message.model.service.MessageService;
import kh.semi.message.model.vo.MessageVo;

/**
 * Servlet implementation class StMessageServlet
 */
@WebServlet("/st/message")
public class StMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet : /st/message");

		MemberVo mvo = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		
		if(mvo == null) {
			response.sendRedirect("stlogin");
		}
		String loginId = mvo.getId();
		ArrayList<MessageVo> msgsend=new MessageService().send(loginId);
		System.out.println("msgsend : " + msgsend);
		
		request.setAttribute("msgsend", msgsend);
		
		ArrayList<MessageVo> msgreceive=new MessageService().receive(loginId);
		System.out.println("msgreceive : "+msgreceive);
		
		request.setAttribute("msgreceive", msgreceive);
		
		request.getRequestDispatcher("/WEB-INF/view/student/stMSG.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

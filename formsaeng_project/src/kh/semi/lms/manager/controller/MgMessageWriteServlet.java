package kh.semi.lms.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.member.model.vo.MemberVo;
import kh.semi.message.model.service.MessageService;
import kh.semi.message.model.vo.MessageVo;

/**
 * Servlet implementation class MgMessageWriteServlet
 */
@WebServlet("/mg/msgwrite")
public class MgMessageWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgMessageWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet/mgmsgwrite");
		request.getRequestDispatcher("/WEB-INF/view/manager/mgMSG.jsp").forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost/mgmsgwrite");
		
//		로그인정보->혜린->ssMemberVo
		MemberVo mbvo=(MemberVo)request.getSession().getAttribute("ssMemberVo");

		//TODO : recevier 가 null인 이유 찾아야함. 화면에선 잘 들어가있음. conosle 200만번찍어봄 개같은거
		String recevier=request.getParameter("sender_name");
		System.out.println("recevier : "+recevier);
//		String recevier=request.getParameter("recevier");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String sender=mbvo.getId();
		System.out.println("sender : "+sender);
		
		MessageVo vo=new MessageVo();
		vo.setRecevier(recevier);
		vo.setMsgTitle(title);
		vo.setMsgContent(content);
		vo.setSender(sender);
		System.out.println("Servlet vo : "+vo);
		
		int result=new MessageService().write(vo);
		
		if(result==0) {
			System.out.println("메시지 글쓰기 실패ㅜㅜㅜㅜㅜㅜ");
		}else {
			System.out.println("메시지 보내기 성공!!!!!");
			response.sendRedirect(request.getContextPath()+"/mg/message");
		}

	}

}

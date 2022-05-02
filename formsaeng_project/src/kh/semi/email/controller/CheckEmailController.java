package kh.semi.email.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.email.Gmail;
import kh.semi.member.model.service.MemberService;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class CheckEmailController
 */
@WebServlet("/cemail")
public class CheckEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmailController() {
        super();
        // TODO Auto-generated constructor stub
    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost : /cemail");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberVo vo = new MemberVo();
		
		vo.setName(name);
		vo.setEmail(email);
		
		MemberVo result = new MemberService().findId(vo);
		
		if(result ==null) {
			System.out.println("입력하신 정보가 없는 정보이거나 잘못된 이메일입니다. 로그인창으로 돌아갑니다.");
//			response.sendRedirect("/pflogin");
			out.print(0);  // 0: email, name과 일치하는 회원정보가 없음
			out.flush();
			out.close();
			return;
		}
		{
			String host = "smtp.gmail.com";
			int port = 587;
			String from = "vhatodeogkrry@gmail.com";
			String recipient = vo.getEmail();
			String subject = "아이디 찾기를 위한 이메일입니다.";
			String content = vo.getName() + "님의 아이디는 " + result.getId() + "입니다.";
			
			
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			
			try {
				Authenticator auth = new Gmail();
				Session session = Session.getInstance(props, auth);
				session.setDebug(true);
				MimeMessage msg = new MimeMessage(session);
				msg.setSubject(subject);
				Address fromAddr = new InternetAddress(from);
				msg.setFrom(fromAddr);
				Address toAddr = new InternetAddress(recipient);
				msg.addRecipient(Message.RecipientType.TO, toAddr);
				msg.setContent(content,"text/html; charset=UTF-8");
				Transport.send(msg);
				out.print(1);  // 1: email 보내기 성공
			} catch (MessagingException e) {
				out.print(-1);  // -1: email 보내기 실패
//				PrintWriter script = response.getWriter();
//				script.println("<script>");
//				script.println("alert('이메일 전송에 실패했습니다.')");
//				script.println("history.back();");
//				script.println("<script>");
			}
			out.flush();
			out.close();
		}
		
	}

}

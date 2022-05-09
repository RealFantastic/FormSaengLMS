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
 * Servlet implementation class SendEmailController
 */
@WebServlet("/sendEmail.ajx")
public class SendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String clientEmail = request.getParameter("email");
		
		MemberVo member = (MemberVo) request.getSession().getAttribute("getMemberInfo");
		
		String name = member.getName();
		String email = member.getEmail();
		
		System.out.println("clientEmail : " + clientEmail);
		System.out.println("email : " + email);
		
		
		if(!clientEmail.equals(email)) {
			out.print(-2);
			out.flush();
			out.close();
			return;
		}else if(clientEmail.equals(email)){
			clientEmail = email;
			
			String host = "smtp.gmail.com";
			int port = 587;
			String from = "vhatodeogkrry@gmail.com";
			String recipient = clientEmail;
			String subject = "비밀번호 찾기에 대한 이메일입니다.";
			String content = "이메일 인증을 위한 인증번호 안내입니다."
								+ name + "님의 비밀번호는 " + member.getPwd() +" 입니다." ;
			
			
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
			}
			request.getSession().removeAttribute("getMemberInfo");
			out.flush();
			out.close();
		}
	}

}

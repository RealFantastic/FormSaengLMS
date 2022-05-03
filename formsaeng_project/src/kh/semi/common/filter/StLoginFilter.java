package kh.semi.common.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kh.semi.member.model.vo.MemberVo;

@WebFilter("/stloginfilter")
public class StLoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		  HttpServletRequest h_request = (HttpServletRequest) request;
		  HttpSession session = h_request.getSession(false); // 없으면 null 반환
		 
		  boolean check = false;
		  
		  MemberVo ssvo = (MemberVo)session.getAttribute("ssMemberVo");
		  String id = ssvo.getId();
		  
		  boolean idCheck = Pattern.matches("^[S][0-9]{10}$", id); // S로 시작해
				  
		  if(session != null) {
		   if(ssvo != null && idCheck == true ) {
			   check = true;
		   }
		  } 
		  
		  if(check==true) {
			  chain.doFilter(request, response); // 세션 정보 있어
		  } else { // 로그인 페이지로 이동
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("window.alert('로그인이 필요한 페이지입니다');");
			out.println("window.location.href='http://localhost:8090/lms/stlogin';");
			out.println("</script>");
			
		    //request.getRequestDispatcher("/WEB-INF/view/student/login.jsp").forward(request, response);
		  }
		 }

	}



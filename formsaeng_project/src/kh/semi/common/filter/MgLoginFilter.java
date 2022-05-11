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

@WebFilter("/MgLoginFilter")
public class MgLoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest) request).getSession(); // 없으면 null 반환
		 
		  boolean check = false;
		  
		  MemberVo ssvo = (MemberVo)session.getAttribute("ssMemberVo");
		  if (ssvo != null) {
		  String id = ssvo.getId();
		  
		  boolean idCheck = Pattern.matches("^[M][0-9]{10}$", id); // M 시작해

				if (session != null) { // 세션 존재
					if (ssvo != null && idCheck == true) {
						check = true; // 로그인도 되어있고 아이디도 적합
						System.out.println("제대로 로그인");
					}
				}

			}

			if (check == true) {
				chain.doFilter(request, response); // 세션 정보 있어
				System.out.println("로그인 되어있음");
			} else { // 로그인 페이지로 이동
				System.out.println("로그인 안되어있음");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("window.alert('로그인이 필요한 페이지입니다');");
				out.println("window.location.href='"+request.getServletContext().getContextPath()+"/mglogin';");
				out.println("</script>");

			}

		}

	}

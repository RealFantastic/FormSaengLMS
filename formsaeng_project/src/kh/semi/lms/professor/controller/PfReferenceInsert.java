package kh.semi.lms.professor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.lms.reference.service.ReferenceService;
import kh.semi.lms.reference.vo.ReferenceVo;

/**
 * Servlet implementation class pfReferenceInsert
 */
@WebServlet("/pf/refinsert")
public class PfReferenceInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfReferenceInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/view/professor/pf_referenceinsertview.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("ref");
		
		String lbAtitle=request.getParameter("title");
		String lbAcontent=request.getParameter("content");
		
		ReferenceVo vo=new ReferenceVo();
		vo.setLbATitle(lbAtitle);
		vo.setLbAContent(lbAcontent);
		
		int result=new ReferenceService().insertReferenceBoard(vo);
		
		if(result==0) {
			System.out.println("���� ��� �Ǿ����ϴ�");
		}else {
			System.out.println("�� ����� �����Ͽ����ϴ� �ٽ� �õ����ּ���");
			response.sendRedirect(request.getContextPath()+"/pf/reflist");
		}
	}

}

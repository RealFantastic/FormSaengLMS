package kh.semi.lms.professor.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.semi.lms.asg.model.dao.AsgListDao;
import kh.semi.lms.asg.model.service.AsgListService;
import kh.semi.lms.asg.model.vo.AsgCommentVo;
import kh.semi.lms.asg.model.vo.AsgFileVo;
import kh.semi.member.model.vo.MemberVo;

/**
 * Servlet implementation class PfAsgCommentServlet
 */
@WebServlet("/pf/asgboard/read/comment")
public class PfAsgCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfAsgCommentServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("dopost 들어왔는가");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해줘야함)
		String fileSavePath = "fUpload";
		
		// 파일 크기 10M 제한
		int uploadSizeLimit = 10*1024*1024;
		String encType = "UTF-8";
		
		if(!ServletFileUpload.isMultipartContent(request))
			response.sendRedirect("");
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath(fileSavePath);
		System.out.println(uploadPath);
		
		File filePath = new File(uploadPath);
		if(!filePath.exists()) filePath.mkdirs();
		
		MultipartRequest multi = new MultipartRequest(request,
				uploadPath,
				uploadSizeLimit,
				encType,
				new DefaultFileRenamePolicy());
		
		// 업로드 된 파일 이름 얻어오기
		String fileName1 = multi.getFilesystemName("fileName1");
		System.out.println(fileName1);
//		if(fileName1 == null) {
//			System.out.println("업로드 실패");
//			out.print(0);
//			out.flush();
//			out.close();
//			return;
//		} 
		
		String cContent = multi.getParameter("cmtCnt");
		String no = multi.getParameter("bANo");
		int bANo = Integer.parseInt(no);
		
		String fPath = "/fUpload/";
		
		System.out.println("cContent : "+cContent);
		System.out.println("bANo : "+bANo);
		
		MemberVo vo = (MemberVo)request.getSession().getAttribute("ssMemberVo");
		String name = vo.getName();
		String id = vo.getId();
		
		
		AsgCommentVo avo = new AsgCommentVo();
		avo.setcWriter(name);
		avo.setbANo(bANo);
		avo.setcContent(cContent);
		avo.setId(id);
		
		AsgFileVo fvo = new AsgFileVo();
		fvo.setfName(fileName1);
		fvo.setfPath(fPath);
		fvo.setbANo(bANo);
		
//		int result1 = new AsgListService().insertAsgComment(avo);
//		int result2 = new AsgListService().insertAsgFile(fvo);
		
		int result1 = new AsgListService().insertAsgComment(avo, fvo);
		
		System.out.println("result1 : "+result1);
		
		if(result1 <= 0 ) {
			out.print(0);
			out.flush();
			out.close();
			return;
		} else {
			out.print("댓글작성완료!");
			out.flush();
			out.close();
		}
		
		

	}

}

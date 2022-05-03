package kh.semi.lms.professor.controller;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kh.semi.lms.asg.model.service.AsgListService;
import kh.semi.lms.reference.service.ReferenceService;

/**
 * Servlet implementation class PfReferenceDelete
 */
@WebServlet("/refdelete.ajx")
public class PfReferenceDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PfReferenceDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//esponse.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost/delete");
		
		String[] refdelno = request.getParameterValues("chk");
		System.out.println(refdelno[0]);
		
		int result = new ReferenceService().multiDeleteBoard(refdelno);		
		PrintWriter out = response.getWriter();
		
		if(result <= 0) {
			out.print(0);
			out.flush();
			out.close();
			return;
		} else {
			out.print(result);
			out.flush();
			out.close();
		}
	}

}

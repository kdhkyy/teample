package com.jang.free;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FreeDelate
 */
@WebServlet("/freeDelete")
public class FreeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fseq=Integer.parseInt(request.getParameter("fSeq"));
		System.out.println(fseq+"어예!");
		FreeDAO fdao = new FreeDAO();
		int res= fdao.freeDelete(fseq);
		if(res==1) {
			System.out.println("지워버렷다뿅><");
			response.sendRedirect("freelist.jsp");
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

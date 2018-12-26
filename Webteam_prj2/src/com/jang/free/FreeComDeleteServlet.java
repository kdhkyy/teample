package com.jang.free;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FreeComDeleteServlet
 */
@WebServlet("/freeComDelete")
public class FreeComDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fseq=Integer.parseInt(request.getParameter("fSeq"));
		int rseq=Integer.parseInt(request.getParameter("rSeq"));
		System.out.println(rseq+"번댓글");
		FreeDAO fdao = new FreeDAO();
		int res= fdao.freeComDelete(rseq);
		if(res==1) {
			System.out.println("지워버렷다뿅><");
			request.getRequestDispatcher("/freeDetail?seq="+fseq).forward(request,response);
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

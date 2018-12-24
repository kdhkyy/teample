package com.jang.free;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FreeUpdateServlet
 */
@WebServlet("/freeUpdate")
public class FreeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String fseq=request.getParameter("fSeq");
	System.out.println(fseq);
	FreeDAO fdao= new FreeDAO();
	FreeVO fvo=fdao.selectOne(Integer.parseInt(fseq));
	request.setAttribute("RES_VO", fvo);
	request.getRequestDispatcher("freeUpdate.jsp").forward(request, response);
   	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String freeTitle = request.getParameter("freeTitle");
		String freeText = request.getParameter("freeText");
		int fSeq = Integer.parseInt(request.getParameter("fSeq"));
		
		FreeVO fvo=new FreeVO();
		fvo.setfSeq(fSeq);
		fvo.setfTitle(freeTitle);
		fvo.setfText(freeText);
		
		FreeDAO fdao = new FreeDAO();
		if(fdao.freeUpdate(fvo)==1) {
			System.out.println("SuckSex");
			response.sendRedirect("/freeDetail?seq="+fvo.getfSeq());
		}
	}

}

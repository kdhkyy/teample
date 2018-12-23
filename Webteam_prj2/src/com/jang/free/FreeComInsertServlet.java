package com.jang.free;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FreeComInsertServlet
 */
@WebServlet("/freeComInsert")
public class FreeComInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fseq= Integer.parseInt(request.getParameter("seq"));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		FreeVO fvo= new FreeVO();
		fvo.setfSeq(fseq);

		FreeComVO cvo= new FreeComVO();
		ArrayList<FreeComVO> list= new ArrayList<FreeComVO>();
		String fct= request.getParameter("freeComText");
		
		cvo.setrText(fct);
		cvo.setfSeq(fseq);
		list.add(cvo);
		
		FreeDAO fdao= new FreeDAO();
		fdao.freeComInsert(cvo);
/*		if(fdao.freeComInsert(fVO)==1)
		{
			System.out.println("success");
			request.getRequestDispatcher("freeDetail.jsp").forward(request, response);
		}*/
		
	}

}

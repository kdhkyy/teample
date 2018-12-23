package com.jang.point;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pointCheckServlet
 */
@WebServlet("/pointCheckServlet")
public class pointCheckServlet extends HttpServlet {
	
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int payPoint = Integer.parseInt(request.getParameter("POINT"));
		System.out.println(payPoint);
		PointDAO dao = new PointDAO();
		int res = 0;
		int point = dao.selectPoint(4);
		System.out.println("사용가능 금액 ="+point + " : " + payPoint + " : " + payPoint*10);
		if(point < (payPoint*10)) res = 1;
		else res = 0;
		PrintWriter out = response.getWriter();
		out.println(res);
		//possiblePoint 사용가능 포인트 mapping 해놓음 
		
	}

}

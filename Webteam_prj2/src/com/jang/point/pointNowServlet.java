package com.jang.point;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class pointOneServlet
 */
@WebServlet("/pointOneServlet")
public class pointNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PointDAO dao = new PointDAO();
		HttpSession sess=request.getSession();
		int mseq=(int) sess.getAttribute("SESS_SEQ");
		int res = dao.selectNow(mseq);
		Gson gson= new Gson();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(res);
		out.println(res);
	}

}

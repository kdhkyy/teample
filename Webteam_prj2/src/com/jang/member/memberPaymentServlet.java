package com.jang.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class memberPaymentServlet
 */
@WebServlet("/memberPaymentServlet")
public class memberPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberPayment(3);
		System.out.println(vo.getmAccountHolder()+vo.getmSeq()+":"+vo.getmBank());
		request.setAttribute("MEMBER", vo);
		request.getRequestDispatcher("/payment-apply.jsp").forward(request, response);
	}

	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}*/

}

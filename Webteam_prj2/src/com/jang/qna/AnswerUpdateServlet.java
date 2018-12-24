package com.jang.qna;

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
 * Servlet implementation class AnswerDetailServlet
 */
@WebServlet("/answerUpdateServlet")
public class AnswerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qSeq= Integer.parseInt(request.getParameter("qSeq"));
		System.out.println(qSeq);
	      request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      QuestionVO fvo= new QuestionVO();
	      fvo.setqSeq(qSeq);

	      AnswerVO avo= new AnswerVO();
	      ArrayList<AnswerVO> list= new ArrayList<AnswerVO>();
	      String aText= request.getParameter("aText");
	      System.out.println(aText);
	      avo.setaText(aText);
	      avo.setqSeq(qSeq);
	      list.add(avo);
	      
	      QuetionDAO fdao= new QuetionDAO();
	      if(fdao.answerUpdate(avo)==1)
	      {
	         System.out.println("success:::: 설마 포스트로 들어왔니??");
	         response.sendRedirect("/questionDetail?qSeq="+qSeq);
//         request.getRequestDispatcher("/questionDetail?qSeq="+qSeq).forward(request, response);
	      }
	}

}

package com.jang.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/questionDetail")
public class QuestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qSeq = Integer.parseInt(request.getParameter("qSeq"));
		System.out.println(qSeq);

		QuetionDAO qDAO = new QuetionDAO();
	    QuestionVO qVO = new QuestionVO();
	    qVO=qDAO.questionOne(qSeq);
	    
	    AnswerVO avo = new AnswerVO();
	    ArrayList<AnswerVO> list = new ArrayList<AnswerVO>();
	    list = qDAO.answerAll(qSeq);
	    System.out.println(list.size());
	   

	    request.setAttribute("RES_VO", qVO);
	    request.setAttribute("RES_LIST", list);
		request.getRequestDispatcher("questionDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*int mSeq = Integer.parseInt(request.getParameter("mSeq"));
		System.out.println(mSeq);
		
		String qText = request.getParameter("qText");
		System.out.println(qText);
		
		QuetionDAO qDAO = new QuetionDAO();
	    QuestionVO qVO = new QuestionVO();
	    
	    qVO = qDAO.questionOne(mSeq);
	    
	    
		request.setAttribute("RES_VO", qVO);
		request.getRequestDispatcher("questionDetail.jsp").forward(request, response);*/
	}

}

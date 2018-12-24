package com.jang.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jang.order.OrderDAO;
import com.jang.order.orderVO;

/**
 * Servlet implementation class QuestionUpdateServlet
 */
@WebServlet("/questionUpdateServlet")
public class QuestionUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int qSeq = Integer.parseInt(request.getParameter("qSeq"));
		String qSeq=request.getParameter("qSeq");
		System.out.println(qSeq + "::: 설마 겟으로 들어왔니?");
		QuetionDAO qdao = new QuetionDAO();
		QuestionVO qVO = qdao.questionOne(Integer.parseInt(qSeq));
		request.setAttribute("RES_VO",qVO);
		request.getRequestDispatcher("questionUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int qSeq = Integer.parseInt(request.getParameter("qSeq"));
		System.out.println(qSeq+"::: 설마 포스트로 들어왔니?");
		String qText = request.getParameter("qText");
		System.out.println(qText +" ::: 큐텍스트");
		
		QuestionVO qvo= new QuestionVO();
		qvo.setqSeq(qSeq);
		qvo.setqText(qText);
		
		QuetionDAO qDAO = new QuetionDAO();
		int res = qDAO.questionUpdate(qvo);
		if(res == 1)
		{
			System.out.println("Update Done.....");
			response.sendRedirect("/questionDetail?qSeq="+qvo.getqSeq());
		}
	}

}

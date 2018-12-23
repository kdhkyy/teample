package com.jang.free;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FreeDetailServlet
 */
@WebServlet("/freeDetail")
public class FreeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fseq=Integer.parseInt(request.getParameter("seq"));
		System.out.println(fseq);
		FreeDAO fDAO = new FreeDAO();
	    FreeVO res=new FreeVO();
	    res=fDAO.selectOne(fseq);  
	    
	    FreeComVO fres=new FreeComVO();
		ArrayList<FreeComVO> list= new ArrayList<FreeComVO>();
		list=fDAO.selectList(fseq);

		request.setAttribute("RES_VO", res);
		request.setAttribute("RES_LIST", list);
		request.getRequestDispatcher("freeDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

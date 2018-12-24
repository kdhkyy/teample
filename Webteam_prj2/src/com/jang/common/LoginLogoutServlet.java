package com.jang.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jang.member.MemberDAO;
import com.jang.member.MemberVO;

/**
 * Servlet implementation class LoginLogoutServlet
 */
@WebServlet("/LoginLogoutServlet")
public class LoginLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
System.out.println("로그인");
String userid = request.getParameter("userid");
String userpw = request.getParameter("userpw");

MemberVO vo = new MemberVO();

vo.setmEmail(userid);
vo.setmPw(userpw);

MemberDAO dao = new MemberDAO();

MemberVO uvo = dao.select(vo);
System.out.println(uvo.getmGubun());

if(uvo.getmGubun() !=null || uvo.getmGubun().equals("")) {

	//순서 -- page request session application
	
	HttpSession session = request.getSession();

	session.setAttribute("SESS_ID", uvo.getmEmail());
	session.setAttribute("SESS_NAME", uvo.getmNickname());
	session.setAttribute("SESS_GRADE_GUBUN", uvo.getmGubun());
	//session.setAttribute("SESS_FROFILE_IMG",uvo.getUser());
	//request.setAttribute("REQ_PNT", "1000");

	
    
	if(uvo.getmGubun().equals("u")) {
		response.sendRedirect("index3.jsp");
		//request. getRequestDispatcher("index.jsp");//.forward(request, response);
		//response.sendRedirect("index.jsp");
		System.out.println("성공");

	}else if (uvo.getmGubun().equals("a")) {
		//request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		response.sendRedirect("index3.jsp");
		System.out.println("admin 성공");
	}

}else {

System.out.println("실패");
request.getRequestDispatcher("index3.jsp").forward(request, response);




}
	}

}

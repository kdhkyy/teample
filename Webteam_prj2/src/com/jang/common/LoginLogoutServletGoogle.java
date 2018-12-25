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
@WebServlet("/LoginLogoutServletGoogle")
public class LoginLogoutServletGoogle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginLogoutServletGoogle() {
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
		String mEmail = request.getParameter("mEmail");
		String mNickname = request.getParameter("mNickname");
		String mPimg = request.getParameter("mPimg");
		
		
		System.out.println(mEmail);
		System.out.println(mNickname);
		System.out.println(mPimg);
	
		MemberVO vo = new MemberVO();

		vo.setmEmail(mEmail);
		

		MemberDAO dao = new MemberDAO();

		MemberVO uvo = dao.selectGoogle(vo);

		System.out.println(uvo);

		try {


			if(uvo.getmGubun() != null) {

				//순서 -- page request session application

				HttpSession session = request.getSession();

				session.setAttribute("SESS_ID", uvo.getmEmail());
				session.setAttribute("SESS_NAME", uvo.getmNickname());
				session.setAttribute("SESS_GRADE_GUBUN", uvo.getmGubun());
				session.setAttribute("SESS_FROM", uvo.getmFrom());
				session.setAttribute("SESS_PIMG", uvo.getmPimg());
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



			}
				
				
			
			
		} catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("가입된 회원이 아닙니다.");
			request.setAttribute("mPimg",mPimg);
			request.setAttribute("mEmail",mEmail);
			request.setAttribute("mNickname",mNickname);
			request.getRequestDispatcher("member-registerGoogle.jsp").forward(request, response);
			
		} finally {
		
		
			request.getParameter(mPimg);
			request.getParameter(mEmail);
			request.getParameter(mNickname);
//			request.setAttribute("M_ID", uvo.setmEmail(mEmail));
//			request.setAttribute("M_NAME", uvo.getmNickname());
//			request.setAttribute("GRADE_GUBUN", uvo.getmGubun());
//			request.setAttribute("M_FROM", uvo.getmFrom());
//			request.setAttribute("M_PIMG", uvo.getmPimg());
			
			request.getRequestDispatcher("member-registerGoogle.jsp").forward(request, response);
			
			System.out.println("로그인 실패");
		}
	}

}
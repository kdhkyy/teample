package com.jang.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jang.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;
/**
 * Servlet implementation class MemberRegister
 */

/*
 * 
 *
   우리꺼에 맞게 파라미터 쏴~~~~~~악 수정 중 12월 21일 6시52분 등록
 * 
 * 
 * 
 * 
 */

@WebServlet("/MemberRegister")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String saveDirectory = "C:/uploads";
		int maxPostSize = 1024 * 1024 * 10; //10M
		String encoding = "UTF-8";
		FileRenamePolicy policy = new MyFileRenamePolicy();
		
		MultipartRequest mrequest = new MultipartRequest(request,saveDirectory,maxPostSize,encoding,policy);
		
		String origPname = mrequest.getOriginalFileName("mPimg");	
		String sysPname = mrequest.getFilesystemName("mPimg");
		String attachFileExt = "jpg";
		if(origPname.lastIndexOf(".") != -1) {
			attachFileExt = origPname.substring(origPname.lastIndexOf(".")+1);
		}
		if(!attachFileExt.toUpperCase().equals("JPG") &&
				!attachFileExt.toUpperCase().equals("PNG") &&
				!attachFileExt.toUpperCase().equals("GIF")
		) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미지 첨부만 가능')</script>");		
		}
		
		
		
		
		//닉네임은  자체가입은 입력받고 구글,카카오,네이버면 가져온 정보대로
		String mNickname = mrequest.getParameter("mNickname");
		String mEmail = mrequest.getParameter("mEmail");
		String mPw = mrequest.getParameter("mPw");
	
		String mPhone = mrequest.getParameter("mPhone");
		String mZipcode = mrequest.getParameter("mZipcode");
		String mAddress = mrequest.getParameter("mAddress");
		String mAddressJibun = mrequest.getParameter("mAddressJibun");
		String mAddressDetail = mrequest.getParameter("mAddressDetail");
		String mBank = mrequest.getParameter("mBank");
		String mAccountNumber = mrequest.getParameter("mAccountNumber");
		String mPush = mrequest.getParameter("mPush");
		String mFrom = mrequest.getParameter("mFrom");
		String mDeleteYn = mrequest.getParameter("mDeleteYn");
		String mGubun = mrequest.getParameter("mGubun");
		
	
		MemberVO mvo = new MemberVO();
		mvo.setmNickname(mNickname);
		mvo.setmEmail(mEmail);
		mvo.setmPw(mPw);
		mvo.setmPimg(origPname);
		mvo.setmPimgSys(sysPname);
		mvo.setmPhone(mPhone);
		mvo.setmZipcode(mZipcode);
		mvo.setmAddress(mAddressDetail);
		mvo.setmAddressJibun(mAddressJibun);
		mvo.setmAddressDetail(mAddressDetail);
		mvo.setmBank(mBank);
		mvo.setmAccountNumber(mAccountNumber);
		mvo.setmPush(mPush);
		mvo.setmFrom(mFrom);
		mvo.setmAddress(mAddress);
		mvo.setmDeleteYn(mDeleteYn);
		mvo.setmGubun(mGubun);
	
		
		
		MemberDAO dao = new MemberDAO();
		int res = dao.insert(mvo);
		if(res > 0) {
			response.sendRedirect("index3.jsp");
		} else {
			response.sendRedirect("404.jsp");
		}
		
	}

}

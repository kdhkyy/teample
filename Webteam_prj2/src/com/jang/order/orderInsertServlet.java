package com.jang.order;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jang.common.MyBatisFactory;

/**
 * Servlet implementation class orderInsertServlet
 */
@WebServlet("/orderInsertServlet")
public class orderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public orderInsertServlet() {
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
		//		request.setCharacterEncoding("UTF-8");
		//		response.setCharacterEncoding("UTF-8");
		//		String orderTitle = request.getParameter("orderTitle");
		//		String orderPoint = request.getParameter("orderPoint");
		//		String placename = request.getParameter("placename");
		//		String lat = request.getParameter("lat");
		//		String lng = request.getParameter("lng");
		//		String orderText = request.getParameter("orderText");
		//		
		//		orderVO ovo= new orderVO();
		//		ovo.setoTitle(orderTitle);
		//		ovo.setoPoint(Integer.parseInt(orderPoint));
		//		ovo.setoAddress(placename);
		//		ovo.setoLat(Double.parseDouble(lat));
		//		ovo.setoLng(Double.parseDouble(lng));
		//		ovo.setoText(orderText);
		//		
		//		OrderDAO odao= new OrderDAO();
		//		if(odao.orderInsert(ovo)==1)
		//		{
		//			System.out.println("insert Done.....");
		//			response.sendRedirect("orderBoarder.jsp");
		//		}
		
		
		OrderDAO odao = new OrderDAO();
		orderVO ovo= new orderVO();
		OrderPicVO opvo= new OrderPicVO();
		
		ArrayList<OrderPicVO> opvolist = new ArrayList<OrderPicVO>();

		SqlSession conn = MyBatisFactory.getFactory().openSession();
		
		String orderTitle=null;
			String orderPoint=null;
			String placename=null;
			String lat=null;
			String lng=null;
			String orderText=null;

		try {
			String saveDirectory = "C:/uploads";
			int maxPostSize = 1000000;
			String encoding = "UTF-8";
			FileRenamePolicy policy = new DefaultFileRenamePolicy();
			MultipartRequest mrequest = null;
			try {
				mrequest = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);
				//1. 파일 copy : in/output stream
				//2. 중복파일 rename         
			} catch (Exception e) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('파일 첨부 문제 발생 잠시 후 다시 시도 해주세요.');</script>");
				//redirect
			}
			orderTitle = mrequest.getParameter("orderTitle");
			orderPoint = mrequest.getParameter("orderPoint");
			placename = mrequest.getParameter("placename");
			lat = mrequest.getParameter("lat");
			lng = mrequest.getParameter("lng");
			orderText = mrequest.getParameter("orderText");
			




			//------------file-----------
			//pname1,pname2
			/*File pfile = mrequest.getFile("pname");
	         String filePname = pfile.getName(); //File Object 이용한 파일명
	         long attachFileSize = pfile.length(); //File Size
			 */
			int next_sseq = odao.selectNextSseq(conn);
			Enumeration formName = mrequest.getFileNames();
			while (formName.hasMoreElements()) {
				String fnames = (String)formName.nextElement();
				String origpnames = mrequest.getOriginalFileName(fnames);
				System.out.println(origpnames);

				if(origpnames != null) {            
					String sysnames = mrequest.getFilesystemName(fnames);
					File pfiles = mrequest.getFile(fnames);
					long attachFileSizes = pfiles.length(); //File Size
					
					opvo.setpicPpath(saveDirectory);
					opvo.setpicOriginname(origpnames);
					opvo.setpicSysname(sysnames);
					opvo.setoSeq(next_sseq);
					if(opvolist.size() == 0) {  
						opvo.setorderYn("Y");
					}else {
						opvo.setorderYn("N");
					}
					opvolist.add(opvo);
				}
			}
			mrequest.getContentType("pname");
			//파일 확장자 처리
			//	                  String attachFileExt ="jpg";
			//	                  if(origpnames.lastIndexOf(".") != -1) {
			//	                     attachFileExt = origpnames.substring(origpnames.lastIndexOf(".")+1);
			//	                  }
			//	                  
			//	                  if(!attachFileExt.toUpperCase().equals("JPG") &&
			//	                        !attachFileExt.toUpperCase().equals("PNG") &&
			//	                        !attachFileExt.toUpperCase().equals("GIF") &&
			//	                        !attachFileExt.toUpperCase().equals("JPEG")) {
			//	                     response.setContentType("text/html; charset=UTF-8");
			//	                     PrintWriter out = response.getWriter();
			//	                     out.println("<script>alert('이미지 파일만 첨부');</script>");
			//	                     //response.sendRedirect("shop_form.jsp");
			//	                  }




			/*try {
	            conn.setAutoCommit(false);
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } // 사용자가 임의로 커밋하겠다.*/


			//conn.rollback(); 정상입력이 안된경우 되돌리기 위해서 ...
			//--------------------------------------------
			// 1. CURRVAL+1 SSEQ 가져오기
			//--------------------------------------------
			

			if(next_sseq > 0) {
				//--------------------------------------------
				// 2. DB저장작업
				//    SHOP_INFO 테이블 정보 입력 : 1번 입력
				//--------------------------------------------
				ovo.setoTitle(orderTitle);
				ovo.setoPoint(Integer.parseInt(orderPoint));
				ovo.setoAddress(placename);
				ovo.setoLat(Double.parseDouble(lat));
				ovo.setoLng(Double.parseDouble(lng));
				ovo.setoText(orderText);
				ovo.setoSeq(next_sseq);

				int infoInsertRes = odao.orderInsert(ovo, conn);

				//--------------------------------------------
				// 3. DB저장작업
				//    SHOP_PIC 테이블 정보 입력 : pvolist.size()번 입력
				//--------------------------------------------
				if(infoInsertRes > 0) {
					
					
					int shopPicInsertRes = 0;
					for(int i=0; i<opvolist.size(); i++) {
						shopPicInsertRes = odao.orderPicInsert(opvolist.get(i), conn);
					}
				}
			}

		}catch(Exception e) {
			try {
				e.printStackTrace();
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//--------------------------------------------
			// * DB close
			//--------------------------------------------
			conn.close();
		}
		System.out.println("insert Done.....");
		response.sendRedirect("orderBoarder.jsp");
	}

}

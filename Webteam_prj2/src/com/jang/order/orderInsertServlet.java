package com.jang.order;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

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
		OrderDAO odao = new OrderDAO();
		orderVO ovo= new orderVO();
		SqlSession conn = MyBatisFactory.getFactory().openSession();
		try {
			/* ---------------------------------------------------------------
			 * shop_pic : cos.jar MultipartParser를 이용한  멀티 파일업로드 드래그 처리
			 * <input type="file" name="files[]" multiple>  name 1개로 여러 파일 올릴 경우
			 * ---------------------------------------------------------------
			 */

			String saveDirectory = "C:/uploads";
			FileRenamePolicy policy = new DefaultFileRenamePolicy();
			int next_sseq = odao.selectNextSseq(conn);
			MultipartParser parser = new MultipartParser(request, 1024 * 1024 * 10,false, false, "UTF-8");
			
			Part part=null;
			HashMap<String, Object> smap = new HashMap<String, Object>();
			ArrayList<OrderPicVO> opvolist  = new ArrayList<OrderPicVO>();
			while ((part = parser.readNextPart()) != null) {
				String inputName = part.getName();
				if (part.isParam()) {
					ParamPart paramPart = (ParamPart)part;
					String value = paramPart.getStringValue();
					smap.put(inputName, value);
				} else if (part.isFile()) {
					OrderPicVO pvo = new OrderPicVO();

					FilePart filePart = (FilePart)part;
					//내가 정의한 파일 리네임 폴리시 사용....셋팅
					filePart.setRenamePolicy(policy);

					String fileName = filePart.getFileName();
					
					//파일업로드
					if (fileName != null) {
						long fileSize = filePart.writeTo(new File(saveDirectory));   //writeTo 하는 동시에 여기서 업로드. 리네임도 같이 진행된다.
						//               filePart.getFileName();     //리네임
						//               filePart.getFilePath();      //원본명
						pvo.setpicPpath(saveDirectory);
						pvo.setpicOriginname(fileName);
						pvo.setpicSysname(filePart.getFileName());
						pvo.setoSeq(next_sseq);
						if(opvolist.size() == 0) {  
							pvo.setorderYn("Y");
						}else {
							pvo.setorderYn("N");
						}
						opvolist.add(pvo);

					} else {
						System.out.println("error");
					}
				}
			} 
			if(next_sseq > 0) {
				//--------------------------------------------
				// 2. DB저장작업
				//    SHOP_INFO 테이블 정보 입력 : 1번 입력
				//--------------------------------------------
				ovo.setoTitle(smap.get("orderTitle").toString());
				ovo.setoPoint(Integer.parseInt(smap.get("orderPoint").toString()));
				ovo.setoAddress(smap.get("placename").toString());
				ovo.setoLat(Double.parseDouble(smap.get("lat").toString()));
				ovo.setoLng(Double.parseDouble(smap.get("lng").toString()));
				ovo.setoText(smap.get("orderText").toString());
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

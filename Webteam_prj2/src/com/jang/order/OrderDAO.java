package com.jang.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jang.common.MyBatisFactory;

public class OrderDAO {
   /**
    * �쉶�썝 �젙蹂� �닔�젙�쓣 �쐞�븳 紐⑤뱺 �젙蹂� 媛��졇�삤湲�
    * @param userId
    * @return
    */
   public  ArrayList<orderVO> selectAll() {
      SqlSession conn =null;
      ArrayList<orderVO> resList =null;
      try {
         conn = MyBatisFactory.getFactory().openSession(); 
         resList =(ArrayList)conn.selectList("orderNameSpace.orderAll");   
      }catch(Exception e) {
    	  conn.close();
      }
      return resList;
   }
   
   public  orderVO selectOne(int oseq) {
	      SqlSession conn =null;
	      orderVO res =null;
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         res =(orderVO)conn.selectOne("orderNameSpace.orderPicdetail",oseq);   
	      }catch(Exception e) {
	    	  conn.close();
	      }
	      return res;
	   }
   
   public int orderInsert(orderVO ovo,SqlSession PRMCONN) {
	      int res = 0;
	      try { 
	         res = PRMCONN.insert("orderNameSpace.orderInsert", ovo);
	         PRMCONN.commit();
	      } catch (Exception e) {
		         PRMCONN.rollback();
		         e.printStackTrace();
		      }
	      return res;
	   }
   
   public int orderPicInsert(OrderPicVO ovo , SqlSession PRMCONN) {
	      int res = 0;
	      try {
	         res = PRMCONN.insert("orderNameSpace.orderPicInsert", ovo);
	         PRMCONN.commit();
	      } catch (Exception e) {
	         PRMCONN.rollback();
	         e.printStackTrace();
	      }
	      return res;
	   }
   
   public int orderUpdate(orderVO ovo) {
	      SqlSession conn =null;
	      int res = 0;
	      try { 

	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.update("orderNameSpace.orderUpdate",ovo);
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
   
   public int orderDelete(int oseq) {
	      SqlSession conn =null;
	      int res = 0;
	      try {
	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.delete("orderNameSpace.orderDelete",oseq);  
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
   public int selectNextSseq(SqlSession PRMCONN) {
	      int next_sseq = 0;
	      try {
	         next_sseq = PRMCONN.selectOne("orderNameSpace.order_nextVal");
	         PRMCONN.commit();
	      } catch (Exception e) {
	         PRMCONN.rollback();
	         e.printStackTrace();
	      }
	      return next_sseq;
	   }
   
   public int chatLogInsert(ChatVO cvo) {
	      int res = 0;
	      SqlSession conn =null;
	      try { 
	    	  conn = MyBatisFactory.getFactory().openSession();
	         res = conn.insert("orderNameSpace.chatInsert", cvo);
	         conn.commit();
	      } catch (Exception e) {
		         conn.rollback();
		         e.printStackTrace();
		      }
	      return res;
	   }
   
   public  ArrayList<ChatVO> selectChatAll(int oseq) {
	      SqlSession conn =null;
	      ArrayList<ChatVO> resList =null;
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         resList =(ArrayList)conn.selectList("orderNameSpace.chatAll",oseq);   
	      }catch(Exception e) {
	    	  conn.close();
	      }
	      return resList;
	   }
   
   public  ChatVO chatSeqToNick(int oseq) {
	      SqlSession conn =null;
	      ChatVO res =null;
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         res =conn.selectOne("orderNameSpace.seqToNick",oseq);   
	      }catch(Exception e) {
	    	  conn.close();
	      }
	      return res;
	   }
   
   
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
   
   
}
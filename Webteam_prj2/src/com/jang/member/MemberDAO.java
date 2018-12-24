package com.jang.member;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jang.common.MyBatisFactory;
import com.jang.order.orderVO;

public class MemberDAO {

	/**
	 * 로그인 정보 가져오기
	 * @param uvo
	 * @return
	 */
	public MemberVO select(MemberVO uvo) {  //login
		SqlSession conn =null;
		MemberVO vo2 = null;
		
		try {
			conn = MyBatisFactory.getFactory().openSession();
			vo2 = conn.selectOne("memberNameSpace.memberLogin", uvo);
		} finally {
			conn.close();
		}
		return vo2;
	}
	/**
	 * 회원가입 입력정보 집어넣기
	 * @param mvo
	 * @return
	 */
	public int insert(MemberVO mvo) {
		SqlSession conn =null;
		int res = 0;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			res = conn.insert("memberNameSpace.memberRegister", mvo);
			conn.commit();
		} finally {
			conn.close();
		}
		return res;
	}
	
	 public MemberVO memberPayment(int mSeq){
	      SqlSession conn = null;
	      MemberVO vo = new MemberVO();
	      try {
	            conn = MyBatisFactory.getFactory().openSession(); 
	            vo =conn.selectOne("memberPayment", mSeq);   
	         }catch(Exception e) {
	            conn.close();
	         }
	         return vo;
	      
	   }

	

	 public  ArrayList<orderVO> memberOrderList() {
	      SqlSession conn =null;
	      ArrayList<orderVO> resList =null; 
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         resList =(ArrayList)conn.selectList("memberNameSpace.memberOrder");   
	      }catch(Exception e) {
	    	  conn.close();
	      }
	      return resList;
	   }
	 
	 public  ArrayList<orderVO> memberMissionList() {
	      SqlSession conn =null;
	      ArrayList<orderVO> resMList =null;
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         resMList =(ArrayList)conn.selectList("memberNameSpace.memberMission");   
	         
	      }catch(Exception e) {
	    	  conn.close();
	      }
	      return resMList;
	   }
	 
	 
	 
	 
	 
	 public  ArrayList<orderVO> memberSearchOrder(int day) {
	      SqlSession conn =null;
	      ArrayList<orderVO> resList =null;
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         resList =(ArrayList)conn.selectList("memberNameSpace.memberSerachOrder",day);   
	      }catch(Exception e) {
	    	  e.printStackTrace();
	    	  conn.close();
	      }
	      return resList;
	   }
	 
	 
	 public  ArrayList<orderVO> memberSearchMission(int day) {
	      SqlSession conn =null;
	      ArrayList<orderVO> resMList =null;
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         resMList =(ArrayList)conn.selectList("memberNameSpace.memberSerachMission",day);   
	      }catch(Exception e) {
	    	  conn.close();
	      }
	      return resMList;
	   }

}

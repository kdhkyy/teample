package com.jang.free;
 
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.jang.common.MyBatisFactory;
import com.jang.free.FreeVO;

public class FreeDAO {  
	public ArrayList<FreeVO> selectAll(){
		SqlSession conn=null;
		ArrayList<FreeVO> resList = null;
		try {
			conn=MyBatisFactory.getFactory().openSession(); 
			resList=(ArrayList)conn.selectList("freeNameSpace.freeAll");
		}catch(Exception e) {
			e.printStackTrace();
			conn.close();
		}
		return resList;
	}
	public  FreeVO selectOne(int fseq) {
	      SqlSession conn =null;
	      FreeVO res =null;
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         res =(FreeVO)conn.selectOne("freeNameSpace.freeOne",fseq);   
	      }catch(Exception e) {
	    	  e.printStackTrace();
	    	  conn.close();
	      }
	      return res;
	   }
	public  ArrayList<FreeComVO> selectList(int fseq) {
	      SqlSession conn =null;
	      ArrayList<FreeComVO> resList = null;
	      try {
	         conn = MyBatisFactory.getFactory().openSession(); 
	         resList =(ArrayList)conn.selectList("freeNameSpace.freeComSelect",fseq);   
	      }catch(Exception e) {
	    	  e.printStackTrace();
	    	  conn.close();
	      }
	      return resList;
	   }
	public int freeInsert(FreeVO fvo) {
	      SqlSession conn =null;
	      int res = 0;
	      try { 
	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.insert("freeNameSpace.freeInsert", fvo);
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
	public int freeComInsert(FreeComVO fvo) {
	      SqlSession conn =null;
	      int res = 0;
	      try { 
	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.insert("freeNameSpace.freeComInsert", fvo);
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
	public int freeUpdate(FreeVO fvo) {
		SqlSession conn = null;
		int res= 0;
		try {
			conn = MyBatisFactory.getFactory().openSession();
	         res = conn.update("freeNameSpace.freeUpdate",fvo);
	         conn.commit();
		}finally {
			conn.close();
		}
		return res;
	}
	public int freeComUpdate(FreeComVO cvo) {
		SqlSession conn = null;
		int res= 0;
		try {
			conn = MyBatisFactory.getFactory().openSession();
	         res = conn.update("freeNameSpace.freeComUpdate",cvo);
	         conn.commit();
		}finally {
			conn.close();
		}
		return res;
	}
	public int freeDelete(int fseq) {
	      SqlSession conn =null;
	      int res = 0;
	      try {
	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.update("freeNameSpace.freeDelete",fseq);  
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
	public int freeComDelete(int rseq) {
	      SqlSession conn =null;
	      int res = 0;
	      try {
	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.delete("freeNameSpace.freeComDelete",rseq);  
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
}

package com.jang.qna;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.jang.common.MyBatisFactory;


public class QuetionDAO {

	/**
	 * 답글이없는 문의 리스트 조회 조회할때는 구분이 seq가 아니라 detail한 구분으로 나오도록(조인)
	 * @param PRMCONN
	 * @return
	 */
	
	public ArrayList<QuestionVO> questionAll() {
		SqlSession conn = null;
		ArrayList<QuestionVO> list = null;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			list = (ArrayList)conn.selectList("QuestionNameSpace.questionAll");
		} catch(Exception e) {
			e.printStackTrace();
	    	 conn.close();
	      } 
		return list;
	}
	
	/**
	 * 특정 회원의 문의내역 조회
	 * @param PRMCONN
	 * @return
	 */
	
	public QuestionVO questionOne(int qSeq) {
		SqlSession conn =null;
		QuestionVO res = null; 
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			res = (QuestionVO)conn.selectOne("QuestionNameSpace.questionOne", qSeq);
		} finally {
			conn.close();
		}
		return res;
	}
	
	/**
	 * 문의_seq에대한 답변 조회
	 * @param PRMCONN
	 * @return
	 */
	
	public ArrayList<AnswerVO> answerAll(int qSeq) {
		SqlSession conn =null;
		ArrayList<AnswerVO> res = null; 
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			res = (ArrayList)conn.selectList("QuestionNameSpace.answerAll", qSeq);
		} finally {
			conn.close();
		}
		return res;
	}
	
	/**
	 * 문의 insert
	 * @param PRMCONN
	 * @return
	 */
	
	public int questionInsert(QuestionVO qvo) {
	      SqlSession conn =null;
	      int res = 0;
	      try { 
	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.insert("QuestionNameSpace.questionInsert",qvo);
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
	
	/**
	 * 문의에 대한 답변 insert
	 * @param PRMCONN
	 * @return
	 */
	
	public int answerUpdate(AnswerVO avo) {
	      SqlSession conn =null;
	      int res = 0;
	      try { 
	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.insert("QuestionNameSpace.answerUpdate",avo);
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
	
	/**
	 * 문의 수정
	 * @param PRMCONN
	 * @return
	 */
	
	 public int questionUpdate(QuestionVO qvo) {
	      SqlSession conn =null;
	      int res = 0;
	      try { 

	         conn = MyBatisFactory.getFactory().openSession();
	         res = conn.update("QuestionNameSpace.questionUpdate", qvo);
	         conn.commit();
	      } finally {
	         conn.close();
	      }
	      return res;
	   }
}

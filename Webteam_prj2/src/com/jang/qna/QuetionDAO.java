package com.jang.qna;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.jang.common.MyBatisFactory;
import com.jang.qna.QuestionVO;

public class QuetionDAO {

	/**
	 * 답글이없는 문의 리스트 조회 조회할때는 구분이 seq가 아니라 detail한 구분으로 나오도록(조인)
	 * @param PRMCONN
	 * @return
	 */
	
	public ArrayList<QuestionVO> selectAll() {
		SqlSession conn = null;
		ArrayList<QuestionVO> list = null;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			list = (ArrayList)conn.selectList("QuestionNameSpace.questionSelect");
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
	
	public ArrayList<QuestionVO> memberquestionSelect(String mNickname) {
		ArrayList<QuestionVO> list = new ArrayList<QuestionVO>(); 
		SqlSession conn =null;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			list = (ArrayList)conn.selectList("QuestionNameSpace.memberquestionSelect", mNickname);
		} finally {
			conn.close();
		}
		return list;
	}
	
	/**
	 * 문의_seq에대한 답변 조회
	 * @param PRMCONN
	 * @return
	 */
	
	public ArrayList<QuestionVO> replyquestionSelect(QuestionVO qvo) {
		ArrayList<QuestionVO> list = new ArrayList<QuestionVO>(); 
		SqlSession conn =null;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			list = (ArrayList)conn.selectList("QuestionNameSpace.replyquestionSelect", qvo);
		} finally {
			conn.close();
		}
		return list;
	}
	
	/**
	 * 문의 insert
	 * @param PRMCONN
	 * @return
	 */
	
	public ArrayList<QuestionVO> insertquestion(QuestionVO qvo) {
		ArrayList<QuestionVO> list = new ArrayList<QuestionVO>(); 
		SqlSession conn =null;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			list = (ArrayList)conn.selectList("QuestionNameSpace.insertquestion", qvo);
		} finally {
			conn.close();
		}
		return list;
	}
	
	/**
	 * 문의에 대한 답변 insert
	 * @param PRMCONN
	 * @return
	 */
	
	public int	replyinsertquestion(QuestionVO qvo, SqlSession PRMCONN) {
		return PRMCONN.insert("QuestionNameSpace.replyinsertquestion", qvo);
	}
	
	/**
	 * 문의 수정
	 * @param PRMCONN
	 * @return
	 */
	
	public int	updatequestion(QuestionVO qvo, SqlSession PRMCONN) {
		return PRMCONN.insert("QuestionNameSpace.updatequestion", qvo);
	}
	
}

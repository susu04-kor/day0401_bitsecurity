package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MemberVo;
import com.example.demo.vo.TransferVo;

public class DBManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlmapconfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	//계좌이체를 위한 메소드를 정의해요
	public static int transfer(TransferVo t) {
//		int re = -1;
		int re = 0;
		SqlSession session = factory.openSession(false);
//		int re1 = session.update("account.withdraw", t);	//돈 인출
//		int re2 = session.update("account.deposit", t);	//돈 입금
		re += session.update("account.withdraw", t);	//돈 인출
		re += session.update("account.deposit", t);	//돈 입금
		
		//opensession(true)를 할 경우에는
		//최봉현 => 이순신 1000원 송금 -> 최봉현에게선 무조건 1000원 빠지고 
		//이순신이란 사람이 (db에) 없으니까 입금이 안됨- 그러면 돈이 사라짐 
		//false로 해놓고 re1, re2가 다 성공해야 작동하도록 바꾸기
//		if(re1==1 && re2 ==1) {
		if(re==2) {
			session.commit();
		}else {
			session.rollback();
		}
		
		return re;
	}
	
	public static List<MemberVo> selectMemberAll(){
		SqlSession session = factory.openSession();
		List<MemberVo> list  = session.selectList("member.selectAll");
		session.close();
		return list;
	}
	
	public static MemberVo selectMember(String username) {
		SqlSession session = factory.openSession();
		MemberVo m = session.selectOne("member.select", username);
		session.close();
		return m;
	}
	
	public static int insertMember(MemberVo m) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("member.insert", m);
		
//		if(모든 작업이 완료되었나요) {
			session.commit();
//		}else {
//			session.rollback();
//		}
		
		session.close();
		return re;
	}
	
	
	
}

package com.spring.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAOImpl implements EmpDAO{

	private SqlSession sqlSession;
	
	EmpDAOImpl(){
		System.out.println("EmpDAOImpl 생성");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("EmpDAOImpl > setSqlSession 호출");
		this.sqlSession = sqlSession;
	}
	
	public List selectEmp() {
		// DB연결 준비
		// DB연결
		// SQL실행
		// 결과확보
		return sqlSession.selectList("mapper.emp.selectEmp");
	}
	

}

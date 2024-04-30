package com.spring.ex01;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex03.param.EmpDTO;

public class EmpDAO {
	/*
	 * static : JVM(java.exe)이 실행될때 new하지 않고도 메모리에 바로 올라감 static 메소드에서는 static만 사용할
	 * 수 있음 가능하면 사용할 때 클래스. 변수 형태로 쓰자
	 */

	private static SqlSessionFactory sqlMapper = null;

	// 주석
	public static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String res = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(res);
//				sqlMapper = new SqlSessionFactoryBuilder().build(reader);

				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				sqlMapper = ssfb.build(reader);

				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sqlMapper;
	}

	public List<EmpDTO> selectAllEmpList() {
		List<EmpDTO> empList = null;

		// getInstance()만 호출해도 EmpDAO.sqlMapper에 담기게 되는데
		// 책에서는 return 받아서 쓰도록 되어있고 큰 의미는 없다
		// sqlMapper는 this.sqlMapper 보다는 EmpDAO.sqlMapper로 쓰는게 더 좋다

		// SqlMApconfig.xml을 읽어서
		// DB접속 정보까지 얻어옴
		sqlMapper = getInstance();

		// DB접속
		SqlSession sqlSession = sqlMapper.openSession();
		empList = sqlSession.selectList("mapper.emp.selectAllEmpList");

		return empList;
	}

	public String selectEname() {
		String ename = null;
		try {
			sqlMapper = getInstance();
			if (sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
				ename = (String) sqlSession.selectOne("mapper.emp.selectEname");
			} else {
				System.out.println("DB접속 실패");
			} // if end

		} catch (Exception e) {
			e.printStackTrace();
		}// try catch end
		return ename;
	}
	
	public Map selectEmpMap() {
		Map scottMap = null;
		
		try {
			sqlMapper = getInstance();
			if (sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
				scottMap = (Map) sqlSession.selectOne("mapper.emp.selectEmpMap");
			} else {
				System.out.println("DB접속 실패");
			} // if end

		} catch (Exception e) {
			e.printStackTrace();
		}// try catch end
			
		return scottMap;
	}
	
	
	public EmpDTO selectEmpResult() {
		EmpDTO dto = null;
		
		try {
			sqlMapper = getInstance();
			if (sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
				dto = (EmpDTO) sqlSession.selectOne("mapper.emp.selectEmpResult");
			} else {
				System.out.println("DB접속 실패");
			} // if end

		} catch (Exception e) {
			e.printStackTrace();
		}// try catch end
		
		return dto;
	}

}

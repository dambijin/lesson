package com.spring.ex03.param;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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


	
	public EmpDTO selectEmpByEmpno(String empno) {
		EmpDTO dto = null;
		
		try {
			sqlMapper = getInstance();
			if (sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
				dto = (EmpDTO) sqlSession.selectOne("mapper.emp.param.selectEmpByEmpno", empno);
			} else {
				System.out.println("DB접속 실패");
			} // if end

		} catch (Exception e) {
			e.printStackTrace();
		}// try catch end
		
		return dto;
	}

}

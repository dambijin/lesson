package com.myspring.pro27.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {

	@Autowired
	private SqlSession sqlSession;

	public List selectEmpList() {
		List list = sqlSession.selectList("mapper.emp.selectEmp");
		return list;
	}

}

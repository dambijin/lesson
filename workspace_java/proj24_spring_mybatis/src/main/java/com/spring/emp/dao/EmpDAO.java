package com.spring.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface EmpDAO {
	
	public List selectEmp();
}

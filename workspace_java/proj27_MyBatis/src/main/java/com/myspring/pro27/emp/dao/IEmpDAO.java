package com.myspring.pro27.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myspring.pro27.emp.dto.EmpDTO;

@Mapper
public interface IEmpDAO {
	List selectTest();
	List selectEmpList();
	EmpDTO selectTest2();
}

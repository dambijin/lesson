package com.myspring.pro27.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.pro27.emp.dao.EmpDAO;
import com.myspring.pro27.emp.dao.IEmpDAO;

@Service

public class EmpService {

	@Autowired
	EmpDAO empDAO;
	
	@Autowired
	IEmpDAO iEmpDAO;
	
	public List listEmp() {
		return empDAO.selectEmpList();
	}
	
	public List test() {
		return iEmpDAO.selectTest();
//		iEmpDAO.insertTest();
//		return null;
	}
}

package com.spring.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.emp.service.EmpService;

public class EmpController extends MultiActionController {

	private EmpService empService;

	EmpController() {
		System.out.println("EmpController 생성");
	}

	public void setEmpService(EmpService empService) {
		System.out.println("EmpController > setEmpService 실행");
		this.empService = empService;
	}

	public ModelAndView listMembers(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("EmpController > listMembers 실행");
		ModelAndView mav = new ModelAndView();

		List list = empService.getEmpList();
		mav.addObject("list",list);
		
//		listEmp.jsp 안에 있는 ${msg }랑 같다
		mav.addObject("msg", "hello spring");
//		listEmp.jsp 로 간다
		mav.setViewName("listEmp");
		
		return mav;
	}
}

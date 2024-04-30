package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userID = request.getParameter("userID");
		String passwd = request.getParameter("passwd");

		System.out.println("userID : " + userID);
		System.out.println("passwd : " + passwd);

//		Stirng url = "/test/result.jsp";
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result"); // jsp파일명만 지정

//		위랑 같다. 아래 처럼 가능하다 
//		ModelAndView mav =mav.setViewName("result");

		// view로 보낼 값들
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);

		return mav;
	}

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = "memberInfo";
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("id",request.getParameter("id"));
		mav.addObject("pw",request.getParameter("pw"));
		
		return mav;
	}
}

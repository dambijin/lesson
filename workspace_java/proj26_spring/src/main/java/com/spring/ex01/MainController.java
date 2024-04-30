package com.spring.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


// bean : 클래스
// Controller Bean으로 등록한다
@Controller
// 클래스에 적용한 @RequestMapping은 HandlerMapping이 처리한다.
// 클래스에 적용한 주소는 메소드 공통으로 사용할수 있음. 맨 앞에 붙어있는 주소이다.
// ip:port/context path/test/*
@RequestMapping("/test")
public class MainController {

	// 메소드에 적용한 @RequestMapping은 HandlerMapping이 처리한다.
	// 실질적인 주소
//	@RequestMapping("/test/main1.do")
	@RequestMapping("/main1.do")
	public ModelAndView main1() {
		System.out.println("main1 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main1");
		mav.setViewName("main");
		
		return mav;
	}
	
//	@RequestMapping("/test/main2.do")
	@RequestMapping("/main2.do")
	public ModelAndView main2() {
		System.out.println("main2 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main2입니다");
		mav.setViewName("main");
		
		return mav;
	}
	
	// 어노테이션에 두개 이상 적용시 중괄호 {}
	@RequestMapping(
					value={"/main3.do", "/main4.do"},
					method= {RequestMethod.GET, RequestMethod.POST}
				)
	public ModelAndView main3() {
		System.out.println("main3 메소드 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main3 입니다");
		mav.setViewName("main");
		
		return mav;
	}
}

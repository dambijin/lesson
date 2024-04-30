package com.myspring.pro29.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

	@RequestMapping("/rest/ajax.do")
	public String ajax1() {
		return "ajax";
	}
	
	// @RequestBody : post방식으로 json을 처리
	// @ResponseBody : String 또는 json으로 리턴해줌
	// @RestController : @Controller + @ResponseBody
	@RequestMapping("/rest/ajax")
	@ResponseBody
//	@ResponseBody public EmpDTO ajax2(@RequestBody EmpDTO dto) {
//	public @ResponseBody EmpDTO ajax2(@RequestBody EmpDTO dto) {
		public EmpDTO ajax2(@RequestBody EmpDTO dto) {
		System.out.println(dto);
		return dto;
	}
	
	@RequestMapping("/rest/redirect")
	public String redirect() {
		return "redirect:/rest/ajax.do";
	}
	
	@RequestMapping("/rest/forward")
	public String forward() {
		return "forward:/rest/ajax.do";
	}
}

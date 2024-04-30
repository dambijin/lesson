package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test/hello")
	public String hello() {
		return "Hello";
	}

	@RequestMapping("/test/member")
	public EmpDTO member() {
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpno(1234);
		empDTO.setEname("민수오빠");
		empDTO.setSal(2800);

		return empDTO;
	}

	@RequestMapping("/test/memberList")
	public Map memberList() {
		Map map = new HashMap();

		List list = new ArrayList();
		for (int i = 0; i < 3; i++) {
			EmpDTO empDTO = new EmpDTO();
			empDTO.setEmpno(1234);
			empDTO.setEname("민수오빠");
			empDTO.setSal((i + 1000) * 2);

			list.add(empDTO);
		}
		map.put("total", 140);
		map.put("list", list);

		return map;
	}

	@RequestMapping("/test/notice/{num}")
	public int notice(@PathVariable("num") int num) {
//		int num = Integer.parseInt(request.getParameter("num"));
		return num;
	}

	@RequestMapping("/test/notice/{num}/{str}")
	public String notice2(@PathVariable("num") int num, @PathVariable("str") String str1) {
//		int num = Integer.parseInt(request.getParameter("num"));
		return str1;
	}

	@RequestMapping("/test/info")
	public EmpDTO info(
//			@ModelAttribute EmpDTO dto) { // getParameter로 받을 수 있는 걸 분석
			// @RequestBody : json만 받아줌
			@RequestBody EmpDTO dto) {
		System.out.println(dto);
		return dto;
	}

}

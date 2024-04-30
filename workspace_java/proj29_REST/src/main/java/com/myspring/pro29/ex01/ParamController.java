package com.myspring.pro29.ex01;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 클래스를 Controller Bean으로 등록함
@RequestMapping("/human/*") // 클래스 공통 접속 주소
public class ParamController {

	@Autowired // 해당 변수 타입에 맞는 Bean을 찾아서 new해서 주입까지 해줌
	EmpDTO empDTO;
	
	@RequestMapping(
			value = {"/a/{addr}/{name}", "/b"}, // vlaue와 {}로 두개 이상 주소를 연결 가능
			method = {RequestMethod.GET} // method 제한, 없으면 모두다 허용
			)
	@ResponseBody // json으로 돌려줌
	public EmpDTO paramTest(
		HttpServletRequest req,
		HttpServletResponse resp,
		Model model,
		// String id = req.getParameter("id")
		// 단 id가 null인 경우 400 Bad Request
		@RequestParam("id") String id, 
		String pw, // @RequestParam("pw") key와 변수가 같다면 생략가능
		@RequestParam(value = "id2", required = false) String id2, // 필수가 아니게 됨
		@RequestParam Map map, // 뭐든 map에 key, value로 담아줌
		@ModelAttribute EmpDTO dto1, // getParameter로 할 수 있는 걸 알아서 dto에 넣음 
		@ModelAttribute("dto3") EmpDTO dto2, // model.addAttribute("dto3", dto2)와 동일
		EmpDTO dto4, // 바로 밑줄과 동일
		
		@PathVariable("name") String name, // 주소 중 key에 해당하는 글씨의 값을 가져옴
		@RequestBody EmpDTO dto5 // post로 넘어온 json분석해서 dto5에 넣음
		) {
		
		return null;
	}
}

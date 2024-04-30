package com.spring.ex04.dynamic;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dynamic")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpDAO empDAO = new EmpDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");

		EmpDTO dto = new EmpDTO();

		String keyword = request.getParameter("keyword");
//		System.out.println("keyword : "+keyword);
		String type = request.getParameter("type");
		System.out.println("keyword : " + keyword);
		System.out.println("type : " + type);

		String orderColumn = request.getParameter("orderColumn");
		String orderType = request.getParameter("orderType");

		/*
		 * type 1 : ename : 이름 2 : sal >= : 연봉(이상)
		 */
//		if ("1".equals(type)) {
//			dto.setEname(keyword);
//		} else if ("2".equals(type)) {
//			try {
//				int sal = Integer.parseInt(keyword);
//				dto.setSal(sal);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if ("4".equals(type)) {
//			try {
//				dto.setJob(keyword);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

		// 부분검색 (checkbox)관련
		String[] chks = request.getParameterValues("chk");
		if (chks != null) {
			for (String chk : chks) {
				System.out.println("chk : " + chk);
			}
		}

		dto.setType(type);
		dto.setKeyword(keyword);

		dto.setOrderColumn(orderColumn);
		dto.setOrderType(orderType);
		dto.setChks(chks);

		// DB조회
		List list = empDAO.getEmpList(dto);
		System.out.println("list.size() : " + list.size());

		request.setAttribute("list", list);
		System.out.println("리스트 : " + list);

		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);

		request.getRequestDispatcher("emp.jsp").forward(request, response);
	}

}

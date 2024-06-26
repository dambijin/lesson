package kr.or.human;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/jdbc")
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controller(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controller(request, response);
	}

	void controller(HttpServletRequest request, HttpServletResponse response) {
		try {
//			한글 깨짐 방지
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8;");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott4_12";
		String password = "tiger";

		try {
//			드라이버 로딩
//			Class.forName : String 변수로 class 생성
			Class.forName(driver);
			System.out.println("Oracle드라이버 로딩 성공");

//			DB접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

//			String name = "SCOTT";
//			String name = "S";
//			String name = "s";
			String name = request.getParameter("name");
			
//			SQL 작성
			
			String query = "";
			query += " select";
			query += " *";
			query += " from";
			query += " emp";
//			query += " where ename = 'SCOTT'";
//			query += " where ename = '"+ name +"'";
//			query += " where ename = ?";
			
//			query += " where ename like '%' || ? || '%'";
			query += " where lower(ename) like '%' || lower(?) || '%'";
			
//			select*fromemp
			System.out.println("query : " + query);

//			SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);

//			SQL실행
			ResultSet rs = ps.executeQuery();
//			select : executeQuery()
//			그 외 : executeUpdate()
//			return : int(몇개의 row가 영향을 받았는지)

//			DB값을 활용
//			ResultSet에는 모든 줄이 담겨져 있음
//			rs.next() : 다음줄이 있는지 여부
//			next() 실행 후에 ResultSet에는 다음줄이 담김
			while (rs.next()) {
//				getxxx, 전달인자로 컬럼명, 대소문자 구분 없음
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
//				날짜 사용하고 싶으면 import된 클래스명이 같기 때문에
//				import java.sql.Date; 이 형태로 써야한다(sql)

				System.out.println("empno : " + empno);
				System.out.println("ename : " + ename);
				System.out.println("hiredate : " + hiredate);
				System.out.println("-----------------");

				PrintWriter out = response.getWriter();
				out.println("<div>empno : " + empno + "</div>");
				out.println("<div>ename : " + ename + "</div>");
				out.println("<div>hiredate : " + hiredate + "</div>");
				out.println("<hr>");
			}

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

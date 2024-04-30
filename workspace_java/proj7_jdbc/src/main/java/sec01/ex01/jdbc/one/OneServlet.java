package sec01.ex01.jdbc.one;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/one")
public class OneServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/one 실행");
		response.setContentType("text/html; charset=utf-8;");
		
		
		long begin = System.currentTimeMillis();
		
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott4_0";
		String password = "tiger";
		
		try {
			// Class.forName : String 변수로 class 생성한다
			// 드라이버 : 서로 다른 것들(java, oracle)이 소통할 수 있게 해주는 것
			// 오라클 드라이버 로딩
			Class.forName(driver);
//			OracleDriver drive = new OracleDriver();
			
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			
			// SQL 준비
			String query = "select * from emp2";
			PreparedStatement ps = con.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			System.out.println("rs :"+ rs);
			
			// 결과 활용
			// ResultSet rs는 조회된 결과 전체 : 2차원 배열 느낌
			// rs.next()를 하고난 rs는 다음줄 덩어리 : 1차원 배열 느낌
//			for(;rs.next();) {}
			while(rs.next()) {
				response.getWriter().print("-------------<br>");
				
				int empno = rs.getInt("empno");
				System.out.println("empno : "+ empno);
				response.getWriter().print("empno : "+ empno +"<br>");
				
				String ename = rs.getString("ename");
				System.out.println("ename : "+ ename);
				response.getWriter().print("ename : "+ ename +"<br>");
			}
			
			rs.close();
			ps.close();
			con.close();
			
			long end = System.currentTimeMillis();
			System.out.println("걸린 시간 : "+ (end - begin));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

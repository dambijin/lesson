package test20240320;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test0324")
public class Test0320Servlet extends HttpServlet {
	private static final String URL = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	private static final String USER = "scott4_12";
	private static final String PASSWORD = "tiger";

//	DB접속 메소드
	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	private static ArrayList<Map<String, String>> getDBTable(String notice) {
		ArrayList<Map<String, String>> result_list = new ArrayList<Map<String, String>>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(notice);
			// select 사용할때는 executeQuery
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = rsmd.getColumnName(i);
					map.put(columnName, rs.getString(columnName));
				}
				result_list.add(map);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result_list;
	}

	private static ArrayList<Map<String, String>> insertDB(String notice) {
		ArrayList<Map<String, String>> result_db = new ArrayList<Map<String, String>>();
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(notice);
//			update insert 사용할때는 executeUpdate
			int rs = ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result_db;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

//		확인할 셀렉트문
		String selectDB = "SELECT * FROM silro ORDER BY s_id deSC";
		ArrayList<Map<String, String>> select = getDBTable(selectDB);
		request.setAttribute("select", select);

		System.out.println("결과문" + select.get(0).get("TEXTAREA"));

		request.getRequestDispatcher("testinput.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		try {
			Connection conn = getConnection();
			String tarea = request.getParameter("tarea");
			String isDB = "INSERT INTO silro (s_id, textarea) VALUES (silro_seq.NEXTVAL, ?)";
			PreparedStatement pst = conn.prepareStatement(isDB);
			pst.setString(1, tarea);
			int result = pst.executeUpdate();
			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("test0324");
	}

}

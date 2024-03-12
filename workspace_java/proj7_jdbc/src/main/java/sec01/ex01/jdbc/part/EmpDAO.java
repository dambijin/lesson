package sec01.ex01.jdbc.part;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

//	만약 유저정보를 private로 안해두면 
//	다른곳에서 유저 정보를 다볼 수 있는 개인정보 문제가 있을 수 있다
//	그래서 private를 해주는 것
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "scott4_12";
	private String password = "tiger";

	private Connection con;

	void connDB() {
//		오라클 드라이버 로딩
		try {
			Class.forName(driver);
//			DB 접속
//			필드 값이니까 this를 잘 붙여준다
			this.con = DriverManager.getConnection(this.url, this.user, this.password);
//		} catch (ClassNotFoundException e) {
//		Exception 으로 그냥 해결해버리기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Connection connDB2() {
		Connection con2 = null;

//		오라클 드라이버 로딩
		try {
			Class.forName(driver);
//			DB 접속
			con2 = DriverManager.getConnection(this.url, this.user, this.password);
//		} catch (ClassNotFoundException e) {
//		Exception 으로 그냥 해결해버리기
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con2;
	}

	List listEmp() {
		connDB();

		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = new ArrayList();

		try {
			// SQL 준비
			String query = "select * from emp2";
			ps = con.prepareStatement(query);
//			SQL 실행 및 결과 확보
			rs = ps.executeQuery();

//			결과 활용
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");

				System.out.println("empno : " + empno);

//				empDTO의 new가 while문 밖에서 되면
//				제대로 실행이 안된다
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setSal(sal);

				list.add(empDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (this.con != null) {
				try {
					this.con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}

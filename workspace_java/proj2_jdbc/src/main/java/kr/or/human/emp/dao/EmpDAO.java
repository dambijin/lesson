package kr.or.human.emp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.human.emp.dto.EmpDTO;

public class EmpDAO {
	List list = new ArrayList();

//	select
//	public List selectEmp(String ename, int deptno) {
	public List selectEmp(EmpDTO empDTO) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott4_12";
		String password = "tiger";

//		드라이버 로딩
//		Class.forName : String 변수로 class생성
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
//			DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

//			SQL 만들기
			String query = "";
			query += " select";
			query += " *";
			query += " from";
			query += " emp2";
			query += " where 1=1";
			query += " where lower(ename) like '%' || lower(?) || '%'";
			if (empDTO.getDeptno() != -1) {
				query += " and deptno = ?";
			}
			System.out.println("query : "+query);

//			SQL 실행준비
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,  empDTO.getEname());			
			
			if(empDTO.getDeptno() != -1) {
				ps.setInt(2, empDTO.getDeptno());
			}
			
//			SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();

//			결과 활용
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename2 = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");

//				System.out.println("empno : " + empno);
//				System.out.println("ename2 : " + ename2);
//				System.out.println("hiredate : " + hiredate);
//				System.out.println("-----------------");

//				Map map = new HashMap();
//				map.put("empno", empno);
//				map.put("ename2", ename2);
//				map.put("hiredate", hiredate);

				EmpDTO dto = new EmpDTO();
				dto.setEmpno(empno);
				dto.setEname(ename2);
				dto.setHiredate(hiredate);

				list.add(dto);
			}
			rs.close();
			ps.close();
			con.close();

//			return list;를 여기서 하게되면 중간에 에러가 남.
//			만약 여기다 적으면 캐치마다 리턴값을 적어줘야함

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private Connection getConn() {
//		DB접속
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
		String user = "scott4_12";
		String password = "tiger";

		Connection con = null;

		try {
//			드라이버 로딩
//			Class.forName : String 변수로 class 생성
			Class.forName(driver);
			System.out.println("Oracle드라이버 로딩 성공");

//			DB접속
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

//	update
	public int updateEmp2(EmpDTO empDTO) {
		int result = -1;
//		DB접속
		Connection con = getConn();
//		SQL준비 및 실행
		String sql = "";
		sql += " update emp2";
		sql += " set ename= ?";
		sql += " WHERE empno =?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empDTO.getEname());
			ps.setInt(2, empDTO.getEmpno());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		ps.setString(1, empDTO.getEname());

//		결과 활용
		return result;
	}
//	insert
//	delete

}

package sec02.ex01.dbcd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import sec01.ex01.jdbc.part.EmpDTO;

public class DbcpDAO {
	private Connection con;
	
	void connDB() {
		try {
		Context ctx=new InitialContext();
		DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
		this.con = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	List listEmp() {
		long begin = System.currentTimeMillis();
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
		long end = System.currentTimeMillis();
		System.out.println("걸린시간 : "+(end-begin));
		
		return list;
	}

}

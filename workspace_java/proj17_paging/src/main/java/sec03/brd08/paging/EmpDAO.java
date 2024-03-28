package sec03.brd08.paging;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class EmpDAO {

	// 목록 조회하는 메소드
	public List<EmpDTO> selectEmp () {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			con = dataFactory.getConnection();

			// SQL 준비
			String query = " select * from emp3";
			ps = con.prepareStatement(query);

			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmpDTO dto = new EmpDTO();
				
//				int empno;
//				String ename;
//				String job;
//				int mgr;
//				Date hiredate;
//				int sal;
//				int comm;
//				int deptno;
				
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setMgr(rs.getInt("mgr"));
				
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
}

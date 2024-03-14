package sec02.ex01.dbcd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import sec01.ex01.jdbc.part.EmpDTO;

public class DbcpDAO {
	private static final int EMPTY_EMPNO = -9999;

	private Connection con;
	
	private void connDB() {
		try {
			
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			this.con = dataFactory.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List listEmp() {
		return listEmp(EMPTY_EMPNO);
	}
	
	List listEmp(int empno) {
		
		long begin = System.currentTimeMillis();
		
		
		/* 꼭 써야함!! */
		connDB();
//		Connection con2 = connDB2();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List list = new ArrayList();
		
		try {
			// SQL 준비
			String query = "select * from emp2";
			if(empno != EMPTY_EMPNO) {
				query += " where empno = ?";
			}

			ps = con.prepareStatement(query);
//			PreparedStatement ps = con2.prepareStatement(query);
			if(empno != EMPTY_EMPNO) {
				ps.setInt(1, empno);
			}

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();
			
			// 결과 활용
			while(rs.next()) {
				int empno21 = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				String job = rs.getString("job");
				
				System.out.println("empno : "+ empno21);
				
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(ename);
				empDTO.setSal(sal);
				empDTO.setJob(job);
				
				list.add(empDTO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(this.con != null) {
				try {
					this.con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+ (end - begin));
		
		return list;

	}
	
	
	// insert
//	int insertEmp2(String a1, String a2, String a3, String a4) {
	int insertEmp2(EmpDTO empDTO) {
		int result = -9999;
		
		/* 꼭 써야함!! */
		connDB();
		
		PreparedStatement ps = null;
		
		try {
			// SQL 준비
			String query = " insert into emp2 (empno, ename, sal, deptno)";
			query += 	   " values(?, ?, ?, ?) ";

			ps = con.prepareStatement(query);
			ps.setInt(1, empDTO.getEmpno());
			ps.setString(2, empDTO.getEname());
			ps.setInt(3, empDTO.getSal());
			ps.setInt(4, empDTO.getDeptno());

			// SQL 실행 및 결과 확보
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(this.con != null) {
				try {
					this.con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	int updateEmp2(EmpDTO empDTO) {
		int result = -9999;
		
		/* 꼭 써야함!! */
		connDB();
		
		PreparedStatement ps = null;
		
		try {
			// SQL 준비
			String query = " UPDATE emp2";
			query += 	   " SET ";
			query += 	   " 	ename = ?, ";
			query += 	   " 	sal = ?, ";
			query += 	   " 	job = ? ";
			query += 	   " WHERE empno = ?";
			
			ps = con.prepareStatement(query);
			ps.setString(1, empDTO.getEname());
			ps.setInt(2, empDTO.getSal());
			ps.setString(3, empDTO.getJob());
			ps.setInt(4, empDTO.getEmpno());
			
			// SQL 실행 및 결과 확보
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(this.con != null) {
				try {
					this.con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	int deleteEmp2(int empno) {
		int result = -9999;
		
		/* 꼭 써야함!! */
		connDB();
		
		PreparedStatement ps = null;
		
		try {
			// SQL 준비
			String query = " DELETE emp2";
			query += 	   " WHERE empno = ?";
			
			ps = con.prepareStatement(query);
			ps.setInt(1, empno);
			
			// SQL 실행 및 결과 확보
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(this.con != null) {
				try {
					this.con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
}

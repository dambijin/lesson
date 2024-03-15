package practice.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import sec01.ex01.jdbc.part.EmpDTO;

public class PracticeDAO {

	private Connection con;

	void connDB() {
		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			this.con = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	select문
	List listEmp() {
		connDB();

		PreparedStatement ps = null;
		ResultSet rs = null;

		List list = new ArrayList();

		try {
			String query = "select * from emp2";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

//			결과 활용
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setJob(job);
				empDTO.setMgr(mgr);
				empDTO.setHiredate(hiredate);
				empDTO.setSal(sal);
				empDTO.setComm(comm);
				empDTO.setDeptno(deptno);

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

//	상세를 위한 empnuber
	List processRequest(HttpServletRequest request,String inemp) {
		String empnumber = request.getParameter("insert_empno");

		connDB();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List emp_insert = new ArrayList();

		try {
			String query = "select * from emp2";
			query += " where empno=" + inemp;
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

//			결과 활용
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setJob(job);
				empDTO.setMgr(mgr);
				empDTO.setHiredate(hiredate);
				empDTO.setSal(sal);
				empDTO.setComm(comm);
				empDTO.setDeptno(deptno);

				emp_insert.add(empDTO);
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
		return emp_insert;

	}


}

package com.heekwoncompany.member;

import java.sql.*;

public class MemberDao {
	
	
	static String driverName = "com.mysql.jdbc.Driver";
	static String url ="jdbc:mysql://localhost:3306/serverdb";
	static String user = "root";
	static String pass = "1234";
	
	public int insertMember(MemberDto dto) {
		
		String id = dto.getId();
		String pw = dto.getPw();
		String name = dto.getUsername();
		String email = dto.getEmail();
		
		String sql = "INSERT INTO members(id,pw,username,email) VALUES ('"+id+"','"+pw+"','"+name+"','"+email+"')";
		
		Connection conn = null;
		Statement stmt = null;
		int dbFlag=0;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			
			stmt = conn.createStatement();
			dbFlag = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dbFlag;
	}
	
	public int idCheck(String id) { //아이디의 중복확인
		int idFlag = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM members WHERE id=?";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				idFlag = 1;
			}else {
				idFlag = 0;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return idFlag;
	}
	
	public int userCheck(String id, String pw) {
		int userFlag = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT pw FROM members WHERE id=?";
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				String dbPw = rs.getString("pw");
				if(dbPw.equals(pw)) {
					userFlag = 1; // 아이디가 존재하므로 회원임
				}else {
					userFlag = 2; // 아이디는 존재하지만 비밀번호 틀림
				}
			}else {
				userFlag = 0;	// 아이디가 존재하지 않으므로 비회원임
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return userFlag; 
		//1이 반환되면 로그인 성공, 0이 반환되면 회원 아님, 2가 반환되면 비밀번호만 틀림
	}
	
}

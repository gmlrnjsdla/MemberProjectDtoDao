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
	
	
	
}

package com.heekwoncompany.member;

import java.sql.*;

public class MemberDao {
	int dbFlag;
	
	static String driverName = "com.mysql.jdbc.Driver";
	static String url ="jdbc:mysql://localhost:3306/serverdb";
	static String user = "root";
	static String pass = "1234";
	
	public int insertMember(String id, String pw, String name, String email) {
		
		String sql = "INSERT INTO members(id,pw,username,email) VALUES ('"+id+"','"+pw+"','"+name+"','"+email+"')";
		
		Connection conn = null;
		Statement stmt = null;
		
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

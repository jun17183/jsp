package com.koreait.board3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getCon() throws Exception {
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/boardver3";
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("연결 성공!");
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps, null);
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) { // con : java-db 연결다리  ps : 쿼리문 실행 역할  rs : (select문만 사용)ps가 실행한 select문의 결과가 담김
		if (rs != null) {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		if (ps != null) {
			try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		if (con != null) {
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}

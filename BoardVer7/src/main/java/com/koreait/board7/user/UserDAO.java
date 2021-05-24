package com.koreait.board7.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board7.DBUtils;

public class UserDAO {
	// id가 있으면 1, 없으면 0 리턴
	public static int selIdChk(String uid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select iuser from t_user where uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid.trim());	// 양옆 빈칸 제거
			rs = ps.executeQuery();
			
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return 0;
	}
	
	public static UserEntity loginUser(UserEntity vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserEntity result = null;
		
		String sql = " select * from t_user where uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = new UserEntity();
				result.setIuser(rs.getInt("iuser"));
				result.setUid(rs.getString("uid"));
				result.setUpw(rs.getString("upw"));
				result.setUnm(rs.getString("unm"));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}

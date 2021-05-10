package com.koreait.board4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board4.user.UserVO;

public class UserDAO {

	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " insert into t_user  "
				+ " (uid, upw, unm, gender) "
				+ " values "
				+ " (?, ?, ?, ?) ";
		
		try {
			con = UserDBUtils.getCon();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			UserDBUtils.close(con, ps);
		}
	}
	
	// 로그인 성공 : 1, 아이디 없음 : 2, 비밀번호 틀림 : 3, 에러 : 0
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select * from t_user where uid = ? ";
		
		try {
			con = UserDBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				if (param.getUpw().equals(rs.getString("upw"))) { return 1; } 
				else { return 3; }
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			UserDBUtils.close(con, ps, rs);
		}
	}
}

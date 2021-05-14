package com.koreait.board5.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board5.DBUtils;

public class UserDAO {

	public static UserVO loginUser(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO result = null;
		
		String sql = " select * from t_user where uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = new UserVO();
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
	
	public static int joinUser(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into t_user (uid, upw, unm, gender) values (?, ?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getUpw());
			ps.setString(3, vo.getUnm());
			ps.setInt(4, vo.getGender());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}

package com.koreait.board4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

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
			con = DBUtils.getCon();
			
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
			DBUtils.close(con, ps);
		}
	}
	
	// 로그인 성공 : 1, 아이디 없음 : 2, 비밀번호 틀림 : 3, 에러 : 0
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select * from t_user where uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String dbPw = rs.getString("upw");
				if (BCrypt.checkpw(param.getUpw(), dbPw)) { // 로그인 성공 -> 성공 시 화면에 찍을 유저 정보를 담아줌 
					param.setIuser(rs.getInt("iuser"));
					param.setUnm(rs.getString("unm"));
					return 1; 
				} else { // 비밀번호 틀림
					return 3; 
				}	
			} else { // 아이디 없음
				return 2; 
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}

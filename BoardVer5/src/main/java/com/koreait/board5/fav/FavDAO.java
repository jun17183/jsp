package com.koreait.board5.fav;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.koreait.board5.DBUtils;

public class FavDAO {

	public static void insFav(int iboard, int iuser) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into t_board_fav (iboard, iuser) values (?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			ps.setInt(2, iuser);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static void delFav(int iboard, int iuser) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " delete from t_board_fav where iboard = ? and iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			ps.setInt(2, iuser);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}

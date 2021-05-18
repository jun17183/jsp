package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class CmtDAO {

	public static void insertCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into t_board_cmt (iboard, cmt, iuser) values (?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setString(2, param.getCmt());
			ps.setInt(3, param.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static List<CmtVO> selectCmtList(CmtVO param) {
		List<CmtVO> list = new ArrayList<CmtVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select a.icmt, a.cmt, b.unm, a.iuser, a.regdate "
				+ " from t_board_cmt a "
				+ " inner join t_user b "
				+ " on a.iuser = b.iuser "
				+ " where a.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				CmtVO vo = new CmtVO();
				vo.setIcmt(rs.getInt("icmt"));
				vo.setCmt(rs.getString("cmt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdate(rs.getString("regdate"));
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static CmtVO selectCmt(CmtVO param) {
		CmtVO vo = new CmtVO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select a.icmt, a.cmt, b.unm, a.iuser, a.regdate "
				+ " from t_board_cmt a "
				+ " inner join t_user b "
				+ " on a.iuser = b.iuser "
				+ " where a.icmt = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				vo.setIcmt(rs.getInt("icmt"));
				vo.setCmt(rs.getString("cmt"));
				vo.setUnm(rs.getString("unm"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setRegdate(rs.getString("regdate"));
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static void deleteCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " delete from t_board_cmt where icmt = ? and iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static void updateCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " update t_board_cmt set cmt = ? where icmt = ? and iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getCmt());
			ps.setInt(2, param.getIcmt());
			ps.setInt(3, param.getIuser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}

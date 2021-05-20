package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class BoardDAO {

	public static List<BoardVO> selectBoardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select A.title, A.iboard, A.regdt, B.unm "
				+ " from t_board A "
				+ " inner join t_user B "
				+ " on A.iuser = B.iuser ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
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
	
	public static BoardVO selectBoard(BoardVO param) {
		BoardVO vo = new BoardVO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select A.title, A.ctnt, A.iboard, A.regdt, A.iuser, B.unm, if(C.iboard IS NULL, 0, 1) AS isFav "
				+ " from t_board A "
				+ " inner join t_user B "
				+ " on A.iuser = B.iuser "
				+ " LEFT JOIN t_board_fav C "
				+ " ON A.iboard = C.iboard "
				+ " AND C.iuser = ? "
				+ " WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());		// 이 iuser는 board글 작성자의 iuser가 아닌 현재 로그인한 사람의 iuser값임(좋아요 눌렀는지 안눌렀는지)
			ps.setInt(2, param.getIboard());
			rs = ps.executeQuery();
			
			if (rs.next()) {
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				vo.setIsFav(rs.getInt("isFav"));
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int insertBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into t_board (title, ctnt, iuser) values (?, ?, ?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int deleteBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " delete from t_board where iboard = ? and iuser = ?  ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int updateBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " update t_board set title = ?, ctnt = ? where iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}


















package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardDAO {
	public static List<BoardDomain> selBoardList(BoardDTO param) {
		List<BoardDomain> list = new ArrayList<BoardDomain>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select a.iboard, a.title, a.iuser, a.regdt, b.unm as writerNm "
				+ " from t_board a "
				+ " inner join t_user b "
				+ " on a.iuser = b.iuser ";
		
		switch(param.getSearchType()) {
		case 1:
			sql += String.format(" where a.title like '%%%s%%' or a.ctnt like '%%%s%%' "
					, param.getSearchText(), param.getSearchText());
			break;
		case 2:
			sql += String.format(" where a.title like '%%%s%%' "
					, param.getSearchText());
			break;
		case 3:	
			sql += String.format(" where a.ctnt like '%%%s%%' "
					, param.getSearchText());
			break;
		case 4:
			sql += String.format(" where b.unm like '%%%s%%' "
					, param.getSearchText());
			// = sql += " where b.unm like & " + page.getSearchText() + " % ";
			break;
		}
		
		sql += " order by a.iboard desc limit ?, ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDomain vo = new BoardDomain();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setWriterNm(rs.getString("writerNm"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static int selPagingCnt(BoardDTO param) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 여기도 검색 시 나오는 페이지 수 설정을 해주어야 함. ~~라고 검색했을 때 페이지 수를 조절해야 하기 때문
		StringBuilder sb = new StringBuilder();
		sb.append(" select ceil(count(iboard) / ?) ")
		.append(" from t_board a ")
		.append(" inner join t_user b ")
		.append(" on a.iuser = b.iuser ");
		
		if (param.getSearchType() > 0) {
			sb.append(" where ");
		}
		
		switch(param.getSearchType()) {
		case 1:
			sb.append(" a.title like '%")
			.append(param.getSearchText())
			.append("%' or a.ctnt like '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 2:
			sb.append(" a.title like '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 3:	
			sb.append(" a.ctnt like '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 4:
			sb.append(" b.unm like '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		}
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);	// 첫번째 컬럼(어차피 값을 하나만 받기 때문에)
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
}
















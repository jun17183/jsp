package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Data Access Object (DB 쿼리 담당)
public class BoardDAO {

	// 글 작성
	public static int insertBoard(BoardVO vo) {	// DB에 '영향받은 행'이라고 나오는 항목이 있음. 그 갯수가 리턴이 됨. 그래서 int 
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board "
				+ " (title, ctnt) "
				+ " VALUES "
				+ " (?, ?) ";
	
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);	// Prepared아님!
			
			ps.setString(1, vo.getTitle());	// 앞 숫자는 물음표 순서
			ps.setString(2, vo.getCtnt());
			
			return ps.executeUpdate();	// 해당 쿼리문(변수 sql)을 실행(insert, update, delete)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);	// finally로 db 닫아주는거 필수!
		}
		
		return 0;
	}

	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT iboard, title, regdt FROM t_board ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();	// select
			
			while(rs.next()) {	// 레코드가 있으면 true. 실행
				BoardVO vo = new BoardVO();
				list.add(vo);
				
				int iboard = rs.getInt(1);		// =rs.getInt("iboard")
				String title = rs.getString(2);
				String regdt = rs.getString(3);
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	};
}







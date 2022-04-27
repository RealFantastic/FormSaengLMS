package kh.semi.board.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kh.semi.board.model.vo.MgBoardListVo;

public class MgBoardDetailDao {

	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public MgBoardListVo detailBoardView(Connection conn, int nno) {
		MgBoardListVo result = null;

		String sql = "select board_notice_title, board_notice_content from notice where board_notice_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
			MgBoardListVo vo = new MgBoardListVo();
			vo.setBoardNoticeTitle(rs.getString("board_Notice_Title"));
			vo.setBoardNoticeContent(rs.getString("board_Notice_Content"));

			result=vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		System.out.println(result);
		return result;

	}
}

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

	public String detailBoardView(Connection conn) {
		String result = null;

		String sql = "board_notice_title, board_notice_content from notice";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			MgBoardListVo vo = new MgBoardListVo();
			vo.setBoardNoticeTitle(rs.getString("board_Notice_Title"));
			vo.setBoardNoticeContent(rs.getString("board_Notice_Content"));

//			result.add(vo);
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

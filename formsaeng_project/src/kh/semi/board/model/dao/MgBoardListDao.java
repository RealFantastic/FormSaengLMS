package kh.semi.board.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.board.model.vo.MgBoardListVo;

public class MgBoardListDao {

	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public ArrayList<MgBoardListVo> view(Connection conn) {
		ArrayList<MgBoardListVo> result = null;

		String sql = "select board_notice_no, " + "board_notice_title, " + "board_notice_content, "
				+ "board_notice_writer," + " TO_CHAR(board_notice_date, 'YYYY-MM-DD') board_notice_date"
				+ " from notice ORDER BY BOARD_NOTICE_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<MgBoardListVo>();

			while (rs.next()) {
				MgBoardListVo vo = new MgBoardListVo();
				vo.setBoardNoticeNo(rs.getInt("board_Notice_No"));
				vo.setBoardNoticeTitle(rs.getString("board_Notice_Title"));
				vo.setBoardNoticeContent(rs.getString("board_Notice_Content"));
				vo.setBoardNoticeWriter(rs.getString("board_Notice_Writer"));
				vo.setBoardNoticeDate(rs.getString("board_Notice_Date"));
				System.out.println(vo); // Console - sql값 확인용

				result.add(vo);
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

package kh.semi.notice.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.notice.model.vo.NoticeVo;

public class NoticeDao {

	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	public ArrayList<NoticeVo> view(Connection conn) {
		ArrayList<NoticeVo> result = null;

		String sql = "select board_notice_no, " + "board_notice_title, " + "board_notice_content, "
				+ "board_notice_writer," + " TO_CHAR(board_notice_date, 'YYYY-MM-DD') board_notice_date"
				+ " from notice ORDER BY BOARD_NOTICE_NO DESC";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<NoticeVo>();

			while (rs.next()) {
				NoticeVo vo = new NoticeVo();
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
	
	
	
	public int insertBoard(Connection conn, NoticeVo vo) {
		int result=0;
		String id = "S1111";
		String name = "홍샛별";
		System.out.println("BoardDao vo : " + vo);
//		private int boardNoticeNo; //공지사항 번호
//		private String boardNoticeTitle; //공지사항 제목
//		private String boardNoticeContent; //공지사항 내용
//		private String boardNoticeWriter; //공지사항 작성자
//		private String boardNoticeDate; //공지사항 작성일자
//		private String id; //작성자 아이디
		
		String sql="insert into notice (BOARD_NOTICE_NO, BOARD_NOTICE_TITLE, BOARD_NOTICE_CONTENT, BOARD_NOTICE_WRITER, BOARD_NOTICE_DATE, ID)"
				+ "values (SEQ_NOTICE_NO.nextval, ?, ?, ?, default, ?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBoardNoticeTitle());
			pstmt.setString(2, vo.getBoardNoticeContent());
			pstmt.setString(3, name);
			pstmt.setString(4, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		System.out.println("Dao result : " + result);
		return result;
	}
	
	
	public NoticeVo detailBoardView(Connection conn, int nno) {
		NoticeVo result = null;

		String sql = "select board_notice_title, board_notice_content from notice where board_notice_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
			NoticeVo vo = new NoticeVo();
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

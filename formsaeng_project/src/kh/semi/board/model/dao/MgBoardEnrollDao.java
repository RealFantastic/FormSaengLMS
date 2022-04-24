package kh.semi.board.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kh.semi.board.model.vo.MgBoardListVo;

public class MgBoardEnrollDao {
//	이름                   널?       유형             
//			-------------------- -------- -------------- 
//			BOARD_NOTICE_NO      NOT NULL NUMBER         
//			BOARD_NOTICE_TITLE   NOT NULL VARCHAR2(150)  
//			BOARD_NOTICE_CONTENT NOT NULL VARCHAR2(2000) 
//			BOARD_NOTICE_WRITER  NOT NULL VARCHAR2(30)   
//			BOARD_NOTICE_DATE    NOT NULL TIMESTAMP(6)   
//			ID                   NOT NULL VARCHAR2(12) 

	private PreparedStatement pstmt=null;
	
	public int insertBoard(Connection conn, MgBoardListVo vo) {
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
}

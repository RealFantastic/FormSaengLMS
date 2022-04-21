package kh.semi.board.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.board.model.vo.BoardVo;
import kh.semi.board.model.vo.CommentVo;

public class BoardDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public int insertBoard(Connection conn,BoardVo vo) {
		int result = 0;
		String Id = vo.getId(); //

		String sql = "insert into ASSIGNMENT_LIST values ((select nvl(max(BOARD_ASSIGNMENT_NO),0)+1 from ASSIGNMENT_LIST),"+"'"+vo.getBATitle()+"','"+vo.getBAContent()+"'"+ ", default, default, "+ "(select name from member where m_id='" + Id + "'),'" + Id + "')";
		
//		String sql = "insert INTO assignment_list values ((select nvl(max(BOARD_ASSIGNMENT_NO),0)+1 from ASSIGNMENT_LIST),"+"'"+vo.getBATitle()+"','BOARD_ASSIGNMENT_WRITER',SYSTIMESTAMP,'BOARD_ASSIGNMENT_CONTENT',(select name from member where id='id'))";
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		return result;		
	}
	
	public ArrayList<BoardVo> AssignmentBoardlist(Connection conn) {
		ArrayList<BoardVo> volist = null;
		
		String sql = "select board_assignment_no, "
                + "board_assignment_title, "
                + "board_assignment_content, "
                + "board_assignment_writer,"
                + " TO_CHAR(board_notice_date, 'YYYY-MM-DD') board_assignment_date"
                + " from assignment_list";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
				volist = new ArrayList<BoardVo>();
				while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBANo(rs.getInt("BOARD_ASSIGNMENT_NO"));
				vo.setBATitle(rs.getString("BOARD_ASSIGNMENT_TITLE"));
				vo.setBAContent(rs.getString("BOARD_ASSIGNMENT_CONTENT"));				
				vo.setBADate(rs.getTimestamp("BOARD_ASSIGNMENT_DATE"));
				vo.setBAWriter(rs.getString("BOARD_ASSIGNMENT_WRITER"));
				System.out.println(vo);
				
				volist.add(vo);		
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return volist;
	}
	
	public ArrayList<BoardVo> AssignmentBoardlist(Connection conn,int startRnum,int endRnum) {
		ArrayList<BoardVo> volist = null;
		
		String sql = "select * from (select rownum rnum, t1.* from (select a.*,(select count(*) from COMMENT c where c.comment_no = a.board_assignment_no) re_CommentCnt from assignment_list a order by board_assignment_date desc, board_assignment_no desc) t1) where rnum between ? and ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			
				volist = new ArrayList<BoardVo>();
				while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBANo(rs.getInt("BOARD_ASSIGNMENT_NO"));
				vo.setBATitle(rs.getString("BOARD_ASSIGNMENT_TITLE"));
				vo.setBAWriter(rs.getString("BOARD_ASSIGNMENT_WRITER"));
				vo.setBADate(rs.getTimestamp("BOARD_ASSIGNMENT_DATE"));
				vo.setBAContent(rs.getString("BOARD_ASSIGNMENT_CONTENT"));
				vo.setId(rs.getString("ID"));
				vo.setReCommentCnt(rs.getInt("re_CommentCnt"));
				volist.add(vo);		
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return volist;
	}
	
	
	public int countListBoard(Connection conn) {
		int result = 0;
		String sql = "select count(*) from assignment_list";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public BoardVo readBoard(Connection conn,int bNo) {
		BoardVo vo= null;
		String sql = "select b.*, (select count(*) from re_Comment r where b_No=?) reCommentCnt from board b where b_No=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, bNo);
			rs = pstmt.executeQuery();
			
			vo= new BoardVo();
			if(rs.next()) {
//				vo.setbNo(rs.getInt("b_No"));
//				vo.setbTitle(rs.getString("b_Title"));
//				vo.setbContent(rs.getString("b_Content"));
//				vo.setbCount(rs.getInt("b_Count"));
//				vo.setbWriteDate(rs.getTimestamp("b_Write_Date"));
//				vo.setbWriter(rs.getString("b_Writer"));
//				vo.setmId(rs.getString("m_Id"));
//				vo.setReCommentCnt(rs.getInt("reCommentCnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}
	
	public ArrayList<BoardVo> searchListBoard(Connection conn,int bNo) {
		ArrayList<BoardVo> volist = null;
		String sql = "select * from board b join re_comment c on order by b_no desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, bNo);
			rs = pstmt.executeQuery();
			
			volist = new ArrayList<BoardVo>();
			if(rs.next()) {
				BoardVo vo = new BoardVo();
//				vo.setbNo(rs.getInt("b_No"));
//				vo.setbTitle(rs.getString("b_Title"));
//				vo.setbContent(rs.getString("b_Content"));
//				vo.setbCount(rs.getInt("b_Count"));
//				vo.setbWriteDate(rs.getTimestamp("b_Write_Date"));
//				vo.setbWriter(rs.getString("b_Writer"));
//				vo.setmId(rs.getString("m_Id"));
//				vo.setReCommentCnt(rs.getInt("reCommentCnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return volist;
	}
	
	public ArrayList<CommentVo> readBoardAndComments(Connection conn, int bNo) {
		ArrayList<CommentVo> volist = null;

		String sql = "select * from re_comment where b_no=? order by r_Write_Date desc, b_no desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();

			volist = new ArrayList<CommentVo>();
			while (rs.next()){
//				CommentVo vo = new CommentVo(
//						rs.getInt("r_no"), rs.getInt("b_no")
//						,rs.getString("r_Writer"), rs.getTimestamp("r_Write_Date")
//						, rs.getString("r_Content"), rs.getString("m_Id")
//						);
				//(int rNo, int bNo, String rWriter, Timestamp rWriteDate, String rContent, String mId)
//				volist.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}		
		return volist;
	}	
	
}

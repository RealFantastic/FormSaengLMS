package kh.semi.lms.asg.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.lms.asg.model.vo.AsgCommentVo;
import kh.semi.lms.asg.model.vo.AsgListVo;

public class AsgListDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public int insertBoard(Connection conn,AsgListVo vo) {
		int result = 0;
		String Id = "S1111"; //todo : 로그인 세션 정보 받아와야함

		String sql = "insert into ASSIGNMENT_LIST values ((select nvl(max(BOARD_ASSIGNMENT_NO),0)+1 from ASSIGNMENT_LIST),?,?,default,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getbATitle());
			pstmt.setString(2, vo.getbAWriter());
			pstmt.setString(3, vo.getbAContent());
			pstmt.setString(4, Id);
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;		
	}
	
	public AsgListVo readBoard(Connection conn, int bANo) {
		AsgListVo vo = null;
		
		String sql = "select board_assignment_no, board_assignment_title, board_assignment_content from assignment_list "
				+ "where board_assignment_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bANo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo= new AsgListVo();
				vo.setbANo(rs.getInt(1));
				vo.setbATitle(rs.getString(2));
				vo.setbAContent(rs.getString(3));
				System.out.println("뿌려졌니? : " + vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}
	
		
	public int updateBoard(Connection conn, AsgListVo vo) {
		int result = 0;
		System.out.println(1);
		String sql = "update ASSIGNMENT_LIST SET BOARD_ASSIGNMENT_TITLE=?, BOARD_ASSIGNMENT_CONTENT=? WHERE BOARD_ASSIGNMENT_NO=?";
		try {
			System.out.println(2);
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, vo.getbATitle());
			pstmt.setString(2, vo.getbAContent());
			pstmt.setInt(3, vo.getbANo());
			System.out.println(3);
			result = pstmt.executeUpdate();
			System.out.println(4);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println(5);
			close(pstmt);
		}
		System.out.println(6);
		return result;
	}
	
	public int deleteBoard(Connection conn, AsgListVo vo) {
		int result = 0;
		String sql = "DELETE ASSIGNMENT_LIST WHERE BOARD_ASSIGNMENT_NO=?";
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getbANo());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result;
	}
	
	public ArrayList<AsgListVo> AssignmentBoardlist(Connection conn) {
		ArrayList<AsgListVo> volist = null;
		
		String sql = "select board_assignment_no, "
                + "board_assignment_title, "
                + "board_assignment_writer,"
                + " TO_CHAR(board_assignment_date, 'YYYY-MM-DD') board_assignment_date"
                + " from assignment_list";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
				volist = new ArrayList<AsgListVo>();
				while(rs.next()) {
				AsgListVo vo = new AsgListVo();
				vo.setbANo(rs.getInt("BOARD_ASSIGNMENT_NO"));
				vo.setbATitle(rs.getString("BOARD_ASSIGNMENT_TITLE"));
				vo.setbADate(rs.getString("BOARD_ASSIGNMENT_DATE"));
				vo.setbAWriter(rs.getString("BOARD_ASSIGNMENT_WRITER"));
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
	
	public ArrayList<AsgListVo> AssignmentBoardlist(Connection conn,int startRnum,int endRnum) {
		ArrayList<AsgListVo> volist = null;
		
		String sql = "select * from (select rownum rnum, t1.* from (select a.*,(select count(*) from COMMENT c where c.comment_no = a.board_assignment_no) re_CommentCnt from assignment_list a order by board_assignment_date desc, board_assignment_no desc) t1) where rnum between ? and ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			
				volist = new ArrayList<AsgListVo>();
				while(rs.next()) {
				AsgListVo vo = new AsgListVo();
				vo.setbANo(rs.getInt("BOARD_ASSIGNMENT_NO"));
				vo.setbATitle(rs.getString("BOARD_ASSIGNMENT_TITLE"));
				vo.setbAWriter(rs.getString("BOARD_ASSIGNMENT_WRITER"));
				vo.setbADate(rs.getString("BOARD_ASSIGNMENT_DATE"));
				vo.setbAContent(rs.getString("BOARD_ASSIGNMENT_CONTENT"));
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
	

	
	public ArrayList<AsgListVo> searchListBoard(Connection conn,int bNo) {
		ArrayList<AsgListVo> volist = null;
		String sql = "select * from board b join re_comment c on order by b_no desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, bNo);
			rs = pstmt.executeQuery();
			
			volist = new ArrayList<AsgListVo>();
			if(rs.next()) {
				AsgListVo vo = new AsgListVo();
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
	
	public ArrayList<AsgCommentVo> readBoardAndComments(Connection conn, int bNo) {
		ArrayList<AsgCommentVo> volist = null;

		String sql = "select * from re_comment where b_no=? order by r_Write_Date desc, b_no desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);
			rs = pstmt.executeQuery();

			volist = new ArrayList<AsgCommentVo>();
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

package kh.semi.lms.asg.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.lms.asg.model.vo.AsgCommentVo;
import kh.semi.lms.asg.model.vo.AsgFileVo;
import kh.semi.lms.asg.model.vo.AsgListVo;

public class AsgListDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	//게시글 추가하기
	public int insertBoard(Connection conn,AsgListVo vo, String id) {
		int result = 0;

		String sql = "insert into ASSIGNMENT_LIST values ((select nvl(max(BOARD_ASSIGNMENT_NO),0)+1 from ASSIGNMENT_LIST),?,?,default,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getbATitle());
			pstmt.setString(2, vo.getbAWriter());
			pstmt.setString(3, vo.getbAContent());
			pstmt.setString(4, id);
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;		
	}
	
	//게시글 상세보기
	public AsgListVo readBoard(Connection conn, AsgCommentVo avo) {
		AsgListVo vo = null;
		
		String sql = "select board_assignment_no, board_assignment_title, board_assignment_content from assignment_list "
				+ "where board_assignment_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, avo.getbANo());
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
	
	public AsgListVo readBoard(Connection conn, int bANo) {
		AsgListVo vo = null;
		
		String sql = "select board_assignment_no, board_assignment_title, BOARD_ASSIGNMENT_WRITER, board_assignment_content from assignment_list "
				+ "where board_assignment_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bANo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo= new AsgListVo();
				vo.setbANo(rs.getInt(1));
				vo.setbATitle(rs.getString(2));
				vo.setbAWriter(rs.getString(3));
				vo.setbAContent(rs.getString(4));
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
	
	//게시글 수정하기	
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
	
	//게시글 삭제하기
	public int deleteBoard(Connection conn, int bANo) {
		int result = 0;
		String sql = "DELETE ASSIGNMENT_LIST WHERE BOARD_ASSIGNMENT_NO = ?";
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bANo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result;
	}
	
	//게시글 여러개 삭제하기
	public int multiDeleteBoard(Connection conn, String[] delNo) {
		
		int result = 0;
		int cnt = 0;
		
		String sql = "DELETE ASSIGNMENT_LIST WHERE BOARD_ASSIGNMENT_NO = ?";
		
			try {
				pstmt = conn.prepareStatement(sql);
				
				for(int i=0; i<delNo.length; i++) {
					pstmt.setString(1, delNo[i]);
					
					result += pstmt.executeUpdate();
				}
				
				//모아둔 쿼리 실행 끝나면 커밋
				if(delNo.length==result) {
					conn.commit();
				} else {
					conn.rollback();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result;
	}
	
	//게시판 목록 띄우기
	public ArrayList<AsgListVo> AssignmentBoardlist(Connection conn) {
		ArrayList<AsgListVo> volist = null;
		
		String sql = "select board_assignment_no, "
                + "board_assignment_title, "
                + "board_assignment_writer,"
                + " TO_CHAR(board_assignment_date, 'YYYY-MM-DD') board_assignment_date"
                + " from assignment_list"
                + " order by board_assignment_date desc";
		
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
	
	//게시판 목록 띄우기(페이징처리)
	public ArrayList<AsgListVo> AssignmentBoardlist(Connection conn,int startRnum,int endRnum) {
		ArrayList<AsgListVo> volist = null;
		
		String sql = "select * from"
                + " (SELECT rownum r, t1.* FROM "
                + " (SELECT BOARD_ASSIGNMENT_NO,BOARD_ASSIGNMENT_TITLE,BOARD_ASSIGNMENT_WRITER,TO_CHAR(BOARD_ASSIGNMENT_DATE, 'YYYY-MM-DD') board_assignment_date,BOARD_ASSIGNMENT_CONTENT"
                + " FROM assignment_list a ORDER BY BOARD_ASSIGNMENT_NO DESC,board_assignment_date DESC)t1)"
                + " where r between ? and ?";
		
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
	
	//게시판 갯수 구하기
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
	
	//댓글 달기
	public int insertAsgComments(Connection conn,AsgCommentVo avo) {
		int result = 0;
		
		String sql = "insert into ASSIGNMENT_COMMENT values (SEQ_COMMENT_NO.nextval,?,DEFAULT,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, avo.getcWriter());
			pstmt.setString(2, avo.getcContent());
			pstmt.setString(3, avo.getId());
			pstmt.setInt(4, avo.getbANo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	//댓글 리스트
	public ArrayList<AsgCommentVo> readBoardAndComments(Connection conn, AsgCommentVo avo) {
		ArrayList<AsgCommentVo> reVolist = null;

		String sql = "select COMMENT_NO,COMMENT_WRITER,COMMENT_DATE,COMMENT_CONTENT,ID,BOARD_ASSIGNMENT_NO"
				+ " from ASSIGNMENT_COMMENT"
				+ " where BOARD_ASSIGNMENT_NO=?"
				+ " order by COMMENT_DATE desc, COMMENT_NO desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, avo.getbANo());
			rs = pstmt.executeQuery();

			reVolist = new ArrayList<AsgCommentVo>();
			while (rs.next()){
				AsgCommentVo vo = new AsgCommentVo();
						
					vo.setcNo(rs.getInt("COMMENT_NO"));
					vo.setcWriter(rs.getString("COMMENT_WRITER"));
					vo.setcDate(rs.getString("COMMENT_DATE"));
					vo.setcContent(rs.getString("COMMENT_CONTENT"));
					vo.setId(rs.getString("ID"));
					vo.setbANo(rs.getInt("BOARD_ASSIGNMENT_NO"));
					
					reVolist.add(vo);
					System.out.println("reVolist(DAO) : " + reVolist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}		
		return reVolist;
	}	
	
	//댓글 삭제하기
		public int deleteComment(Connection conn, int cNo) {
			int result = 0;
			String sql = "DELETE ASSIGNMENT_COMMENT WHERE COMMENT_NO=?";
			
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, cNo);
					
					result = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
			
			return result;
		}
		
	//시퀀스 숫자 값 불러오기
		public int selectSeqCommentNoNextVal(Connection conn) {
			int result = 0;
			String sql = "select SEQ_COMMENT_NO.nextval from dual";
			
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
	//댓글 달기(파일업로드)
		public int insertAsgComment(Connection conn, AsgCommentVo avo, int nextVal) {
			int result = 0;
			
			String sql = "INSERT INTO ASSIGNMENT_COMMENT VALUES ("+nextVal+",?,default,?,?,?)";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, avo.getcWriter());
				pstmt.setString(2, avo.getcContent());
				pstmt.setString(3, avo.getId());
				pstmt.setInt(4, avo.getbANo());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}
	
	//댓글 파일 추가
		public int insertAsgFile(Connection conn, AsgFileVo fvo, int nextVal) {
			int result = 0;
			
			String sql = "INSERT INTO ASSIGNMENT_FILE VALUES (SEQ_ASG_FILE_NO.nextval,?,?,?,?)";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, fvo.getfName());
				pstmt.setString(2, fvo.getfPath());
				pstmt.setInt(3, fvo.getbANo());
				pstmt.setInt(4, nextVal);

				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
		
		
		//댓글 리스트 + 파일업로드
		public ArrayList<AsgCommentVo> readBoardAndComment(Connection conn, AsgCommentVo avo) {
			ArrayList<AsgCommentVo> reVolist = null;

			String sql = "select * from (select  *  from ASSIGNMENT_COMMENT where board_assignment_no = ?) c  left outer join ASSIGNMENT_FILE f using (comment_no)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, avo.getbANo());
				rs = pstmt.executeQuery();

				reVolist = new ArrayList<AsgCommentVo>();
				while (rs.next()){
					AsgCommentVo vo = new AsgCommentVo();
							
						vo.setcNo(rs.getInt("COMMENT_NO"));
						vo.setcWriter(rs.getString("COMMENT_WRITER"));
						vo.setcDate(rs.getString("COMMENT_DATE"));
						vo.setcContent(rs.getString("COMMENT_CONTENT"));
						vo.setId(rs.getString("ID"));
						vo.setbANo(rs.getInt("BOARD_ASSIGNMENT_NO"));
						vo.setfName(rs.getString("BOARD_FILE_NAME"));
						vo.setfPath(rs.getString("BOARD_FILE_PATH"));
						
						reVolist.add(vo);
						System.out.println("reVolist(DAO) : " + reVolist);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}		
			return reVolist;
		}	
		
}

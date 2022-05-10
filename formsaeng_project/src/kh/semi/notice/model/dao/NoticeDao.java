package kh.semi.notice.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.util.SimpleSetOfCharArray;

import kh.semi.notice.model.vo.NoticeVo;
import oracle.sql.ArrayDescriptor;

public class NoticeDao {

	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;


//	//공지사항 리스트
//	public ArrayList<NoticeVo> view(Connection conn) {
//		ArrayList<NoticeVo> volist = null;
//
//		String sql = " select rownum rn , a.* from ( select board_notice_no, " + "board_notice_title, " + "board_notice_content, "
//				+ "board_notice_writer," + " TO_CHAR(board_notice_date, 'YYYY-MM-DD') board_notice_date"
//				+ " from notice ORDER BY BOARD_NOTICE_NO DESC ) a";
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			volist = new ArrayList<NoticeVo>();
//
//			while (rs.next()) {
//				NoticeVo vo = new NoticeVo();
//				vo.setBoardNoticeNo(rs.getInt("board_Notice_No"));
//				vo.setBoardNoticeTitle(rs.getString("board_Notice_Title"));
//				vo.setBoardNoticeContent(rs.getString("board_Notice_Content"));
//				vo.setBoardNoticeWriter(rs.getString("board_Notice_Writer"));
//				vo.setBoardNoticeDate(rs.getString("board_Notice_Date"));
//				vo.setRn(rs.getString("rn"));
//				System.out.println(vo); // Console - sql값 확인용
//
//				volist.add(vo);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		System.out.println(volist);
//		return volist;
//	}


	// 공지사항 리스트 + 페이징
	public ArrayList<NoticeVo> view(Connection conn, int startRnum, int endRnum) {
		ArrayList<NoticeVo> volist=null;
		
//		" select rownum rn , a.* from ( select board_notice_no, " + "board_notice_title, " + "board_notice_content, //		+ "board_notice_writer," + " TO_CHAR(board_notice_date, 'YYYY-MM-DD') board_notice_date"
//		+ " from notice ORDER BY BOARD_NOTICE_NO DESC ) a";
		
//		"select * from (select rownum r, t1.*from(select * from notice ORDER BY BOARD_NOTICE_NO DESC )t1) where r between ? and ?"
		
		String sql =" select * from "
				+ "		(select rownum r, t1.*from"
				+ "			(select board_notice_no,board_notice_title,board_notice_content, board_notice_writer, TO_CHAR(board_notice_date, 'YYYY-MM-DD') board_notice_date "
				+ "			from notice ORDER BY BOARD_NOTICE_NO DESC )t1)"
				+ "	where r between ? and ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,startRnum);
			pstmt.setInt(2,endRnum);
			rs=pstmt.executeQuery();
			
				volist=new ArrayList<NoticeVo>();
				while(rs.next()) {
					NoticeVo vo=new NoticeVo();
					vo.setBoardNoticeNo(rs.getInt("board_Notice_No"));
					vo.setBoardNoticeTitle(rs.getString("board_Notice_Title"));
					vo.setBoardNoticeContent(rs.getString("board_Notice_Content"));
					vo.setBoardNoticeWriter(rs.getString("board_Notice_Writer"));
					vo.setBoardNoticeDate(rs.getString("board_Notice_Date"));
//					vo.setRn(rs.getString("rn"));
					System.out.println("noticeDAO : "+vo);
					
					volist.add(vo);
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return volist;
		
		}
	public int countNotice(Connection conn) {
		int result=0;
		String sql="select count(*) from notice";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
	
		return result;
	}


	//공지사항 등록
	public int insertBoard(Connection conn, NoticeVo vo) {
//		이름                   널?       유형             
//		-------------------- -------- -------------- 
//		BOARD_NOTICE_NO      NOT NULL NUMBER         
//		BOARD_NOTICE_TITLE   NOT NULL VARCHAR2(150)  
//		BOARD_NOTICE_CONTENT NOT NULL VARCHAR2(2000) 
//		BOARD_NOTICE_WRITER  NOT NULL VARCHAR2(30)   
//		BOARD_NOTICE_DATE    NOT NULL TIMESTAMP(6)   
//		ID                   NOT NULL VARCHAR2(12) 
		
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


	// 공지사항 상세
	public NoticeVo detailBoardView(Connection conn, int nno) {
		NoticeVo result = null;

		String sql = "select board_notice_no,board_notice_title, board_notice_content from notice where board_notice_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
			NoticeVo vo = new NoticeVo();
			vo.setBoardNoticeNo(rs.getInt("board_notice_no"));
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


	// 공지사항 삭제
		public int deleteBoard(Connection conn, int[] dellist) {
			
			String sql="DELETE from notice where board_notice_no = ?";
			int cnt = 0;
			try {
				for(int i =0; i<dellist.length ; i++) {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, dellist[i]);
					cnt += pstmt.executeUpdate();
					// cnt에 누적(+=) 
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			System.out.println("cnt"+cnt);
			return cnt;
		}


		// 공지사항 검색
		public ArrayList<NoticeVo> selecNotice(Connection conn, String ff, String qq){
			ArrayList<NoticeVo> volist=new ArrayList<NoticeVo>();
//			
			qq = "%"+qq.trim()+"%";
			System.out.println(qq);
			
			String sql = "select board_notice_no, board_notice_title, board_notice_content, "
						+ "board_notice_writer, TO_CHAR(board_notice_date, 'YYYY-MM-DD') board_notice_date"
						+ " from notice where 1=1 and "+ff+" like ? order by board_notice_no desc";
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, qq);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					do {
						NoticeVo nvo = new NoticeVo();
						nvo.setBoardNoticeNo(rs.getInt("board_Notice_No"));
						nvo.setBoardNoticeTitle(rs.getString("board_Notice_Title"));
						nvo.setBoardNoticeContent(rs.getString("board_Notice_Content"));
						nvo.setBoardNoticeWriter(rs.getString("board_Notice_Writer"));
						nvo.setBoardNoticeDate(rs.getString("board_Notice_Date"));
						
						volist.add(nvo);
					}while(rs.next());
				}
				
				System.out.println("dao 검색결과 : " + volist);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				close(rs);
				close(stmt);
			}
		
			return volist;
		}			




		//공지사항 수정
		public int updateBoard(Connection conn, NoticeVo vo) {
			int result=0;
			
			String sql="update notice set BOARD_NOTICE_TITLE=?, BOARD_NOTICE_CONTENT=? where BOARD_NOTICE_NO=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				//get 가져온다, set 저장시킨다.
				//1번 ?에 vo에 저장되어있는 getBoardNoticeTitle을 가져온다. pstmt에 setString형식으로 저장시킨다.
				pstmt.setString(1, vo.getBoardNoticeTitle());
				pstmt.setString(2, vo.getBoardNoticeContent());
				pstmt.setInt(3, vo.getBoardNoticeNo());
				
				result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}	
		
		
	}


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


	//공지사항 리스트
	public ArrayList<NoticeVo> view(Connection conn) {
		ArrayList<NoticeVo> result = null;

		String sql = " select rownum rn , a.* from ( select board_notice_no, " + "board_notice_title, " + "board_notice_content, "
				+ "board_notice_writer," + " TO_CHAR(board_notice_date, 'YYYY-MM-DD') board_notice_date"
				+ " from notice ORDER BY BOARD_NOTICE_NO DESC ) a";

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
				vo.setRn(rs.getString("rn"));
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
			    // then obtain an Array filled with the content below
				
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
		public List<NoticeVo> selecNotice(Connection conn, String searchCondition, String searchValue){
			List<NoticeVo> noticeList=new ArrayList<>();
			//TODO-sb
//			String sql= query.getProperty("selectNotice");
//			
//			if(searchCondition.equals("title")) {
//				//검색조건이 제목인 경우
//				sql=query.getProperty("selectTitleNotice");
//			}else if(searchCondition.equals("content")) {
//				//검색 조건이 내용인 경우
//				sql=query.getProperty("selectContentNotice");
//			}
//			
//			try {
//				pstmt=conn.prepareStatement(sql);
//				if(searchCondition.equals("title")||searchCondition.equals("content")) {
//					pstmt.setString(1, searchValue);
//				}
//				rset=pstmt.executeQuery();
//				while(rset.next()) {
//					noticeList.add(new Notice(
//							NoticeVo vo = new NoticeVo();
//							vo.getBoardNoticeNo(rs.getInt("board_Notice_No"));
//							vo.getBoardNoticeTitle(rs.getString("board_Notice_Title"));
//							vo.getBoardNoticeContent(rs.getString("board_Notice_Content"));
//							vo.getBoardNoticeWriter(rs.getString("board_Notice_Writer"));
//							vo.getBoardNoticeDate(rs.getString("board_Notice_Date"));
//							System.out.println(vo); // Console - sql값 확인용
//
//							));
//				}
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close(rs);
//				clone(pstmt);
//			}
			return noticeList;
		}
		public List<NoticeVo> selecNotice(Connection conn){
			List<NoticeVo> noticeList=new ArrayList<>();
			// TODO-sb
			return noticeList;
		}	
		
		
	}


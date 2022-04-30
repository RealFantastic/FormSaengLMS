package kh.semi.notice.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import static kh.semi.lms.common.jdbc.JdbcDbcp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import kh.semi.notice.model.dao.NoticeDao;
import kh.semi.notice.model.vo.NoticeVo;

public class NoticeService {

		// 공지사항 리스트
		public ArrayList<NoticeVo> view(){
			Connection conn = getConnection();
			
			ArrayList<NoticeVo> result=null;
			
			result=new NoticeDao().view(conn);
			
			close(conn);
			return result;
		}
		
		
		// 공지사항 상세
		public NoticeVo detailBoardView(int nno) {
			Connection conn = getConnection();

			NoticeVo vo = new NoticeDao().detailBoardView(conn, nno);
			
			close(conn);
			return vo;
		}
		
		
		// 공지사항 등록(Enroll)
		public int insertBoard(NoticeVo vo) {
			int result=0;
			
			Connection conn=getConnection();
			
			result=new NoticeDao().insertBoard(conn, vo);
			
			return result;
		}
		
		
		// 공지사항 삭제(Delete)
		public int deleteBoard(int[] dellist) {
			Connection conn=getConnection();
			
			int cnt =new NoticeDao().deleteBoard(conn,dellist);
			close(conn);
			return cnt;
		}
		
		
		// 공지사항 검색
		public List<NoticeVo> selectNotice(String searchCondition, String searchValue) {
			Connection conn=getConnection();
			List<NoticeVo> listNotice=new NoticeDao().selecNotice(conn, searchCondition, searchValue);
			close(conn);
			
			return listNotice;
		}

		public List<NoticeVo> selectNotice() {
			Connection conn=getConnection();
			List<NoticeVo> listNotice=new NoticeDao().selecNotice(conn);
			close(conn);
			
			return listNotice;
		}
		
		
		
		
}
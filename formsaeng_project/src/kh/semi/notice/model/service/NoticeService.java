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
//		public ArrayList<NoticeVo> view(){
//			Connection conn = getConnection();
//			
//			ArrayList<NoticeVo> volist=null;
//			
//			volist=new NoticeDao().view(conn);
//			
//			close(conn);
//			return volist;
//		}
		
		// 공지사항 페이징
		public ArrayList<NoticeVo> view(int startRnum, int endRnum){
			Connection conn=getConnection();
			ArrayList<NoticeVo> volist=new NoticeDao().view(conn, startRnum,endRnum);
			close(conn);
			return volist;
		}
		public int countNotice() {
			Connection conn=getConnection();
			int result=new NoticeDao().countNotice(conn);
			close(conn);
			return result;
		}
		
		public int updateBoard(NoticeVo vo) {
			int result=0;
			
			Connection conn=getConnection();
			
			result=new NoticeDao().updateBoard(conn, vo);
			
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
		public List<NoticeVo> selectNotice(String reqSearch) {
			Connection conn=getConnection();
			List<NoticeVo> listNotice=new NoticeDao().selecNotice(conn, reqSearch);
			close(conn);
			
			return listNotice;
		}

	
}
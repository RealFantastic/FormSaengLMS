package kh.semi.notice.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.semi.notice.dao.NoticeDao;
import kh.semi.notice.vo.NoticeVo;

public class NoticeService {

		public ArrayList<NoticeVo> view(){
			Connection conn = getConnection();
			
			ArrayList<NoticeVo> result=null;
			
			result=new NoticeDao().view(conn);
			
			close(conn);
			return result;
		}
}

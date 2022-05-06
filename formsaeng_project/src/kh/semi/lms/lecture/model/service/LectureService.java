package kh.semi.lms.lecture.model.service;

import java.sql.Connection;

import kh.semi.lms.lecture.model.dao.LectureDao;
import kh.semi.lms.lecture.model.vo.LectureVo;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;
public class LectureService {

	public int insertVideo(LectureVo vo) {
		Connection conn = getConnection();
		int result = new LectureDao().insertVideo(conn, vo);
		System.out.println("vo : "+vo);
		close(conn);
		return result;
	}
}

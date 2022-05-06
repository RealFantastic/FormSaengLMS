package kh.semi.lms.lecture.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import kh.semi.lms.lecture.model.vo.LectureVo;

public class LectureDao {
	private PreparedStatement pstmt = null;
//	private Statement stmt = null;
	private ResultSet rs = null;
	
	public int insertVideo(Connection conn,LectureVo vo) {
		int result = 0;

		String subjCode = "C0101";
		System.out.println("dao드루왔니?");
		
		String sql = "INSERT INTO WEEK_LECTURE (LECTURE_NO,WEEK_NO,VIDEO_TITLE,UPLOAD_DATE,SUBJECT_CODE,FILE_NAME,FILE_PATH) "
				+ " VALUES ((select nvl(max(LECTURE_NO),0)+1 from WEEK_LECTURE),?,?,DEFAULT,?,?,?)";
		System.out.println("ㅎㅇ");
		System.out.println(vo.getWeekNo());
		System.out.println(vo.getvTitle());
		System.out.println(vo.getfName());
		System.out.println(vo.getfPath());
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getWeekNo());
			pstmt.setString(2, vo.getvTitle());
			pstmt.setString(3, subjCode);
			pstmt.setString(4, vo.getfName());
			pstmt.setString(5, vo.getfPath());
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		return result;		
	}
}

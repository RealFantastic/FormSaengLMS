package kh.semi.lms.lecture.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;

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
	
	public ArrayList<LectureVo> lectureBoardList(Connection conn, String id, String subCode){
		ArrayList<LectureVo> volist = null;
		
//		String id = "S2022954112";
//		String subCode = "C0101";
				
		String sql = "select * "
				+ " from week_lecture w join enrollment_student e"
				+ " on w.subject_code = e.subject_code"
				+ " where e.id = ? and w.subject_code=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, subCode);
			
			rs =pstmt.executeQuery();
			
			volist = new ArrayList<LectureVo>();
			while(rs.next()) {
				LectureVo vo = new LectureVo();
				vo.setLecNo(rs.getInt("LECTURE_NO"));
				vo.setWeekNo(rs.getInt("WEEK_NO"));
				vo.setvTitle(rs.getString("VIDEO_TITLE"));
				vo.setvLength(rs.getInt("VIDEO_LENGTH"));
				vo.setUploadDate(rs.getString("UPLOAD_DATE"));
				vo.setSubCode(rs.getString("SUBJECT_CODE"));
				vo.setfName(rs.getString("FILE_NAME"));
				vo.setfPath(rs.getString("FILE_PATH"));
				
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
	
	public LectureVo lecturePath(Connection conn, int lecNo) {
		LectureVo vo = null;
		
		String sql = "select * from WEEK_LECTURE where LECTURE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lecNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new LectureVo();
				vo.setLecNo(rs.getInt("LECTURE_NO"));
				vo.setWeekNo(rs.getInt("WEEK_NO"));
				vo.setvTitle(rs.getString("VIDEO_TITLE"));
				vo.setvLength(rs.getInt("VIDEO_LENGTH"));
				vo.setUploadDate(rs.getString("UPLOAD_DATE"));
				vo.setSubCode(rs.getString("SUBJECT_CODE"));
				vo.setfName(rs.getString("FILE_NAME"));
				vo.setfPath(rs.getString("FILE_PATH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
}

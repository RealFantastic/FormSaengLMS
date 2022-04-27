package kh.semi.lms.reference.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.lms.reference.vo.ReferenceVo;

public class ReferenceDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public int insertLectureBoard(Connection conn, ReferenceVo vo) {
		int result = 0;
		String Code = vo.getLbACode();
		String sql = "insert into board values()"; //sql인설트문 추가해야함
//		Connection conn = JdbcDbcp.getConnection();
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(stmt);
			}
				return result;
	}
	public ArrayList<ReferenceVo> LectureBoardlist(Connection conn){
		ArrayList<ReferenceVo> volist = null;
		
		String sql = "select REF_NO,"
				+"REF_TITLE,"
				+"REF_WRITER,"
				+"TO_CHAR(REF_WRITE_DATE,'YYYY_MM_DD') REF_WRITE_DATE"
				+"SUBJECT_CODE";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			volist	 = new ArrayList<ReferenceVo>();
			while(rs.next()) {
				ReferenceVo vo = new ReferenceVo();
				vo.setLbAno(rs.getInt("REF_NO"));
				vo.setLbATitle(rs.getString("REF_TITLE"));
				vo.setLbAWriter(rs.getString("REF_WRITER"));
				vo.setLbADate(rs.getString("REF_WRITE_DATE"));
				vo.setLbACode(rs.getString("SEBJECT_CODE"));
				System.out.println(vo);
				volist.add(vo);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return volist;
	}
//	public ArrayList<LectrueBoardVo> LectureBoardlist(Connection conn,int startRnum,int endRnum) {
///		ArrayList<LectrueBoardVo> volist = null;
//		
//		String sql = "select * from(select rownum rnum t1"
		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, startRnum);
//			pstmt.setInt(2, endRnum);
//			rs = pstmt.executeQuery();
//			
//				volist = new ArrayList<LectrueBoardVo>();
//				while(rs.next()) {
//				LectrueBoardVo vo = new LectrueBoardVo();
//				vo.setLbAno(rs.getInt("REF_NO"));
//				vo.setLbATitle(rs.getString("REF_TITLE"));
//				vo.setLbACotent(rs.getString("REF_CONTENT"));
//				vo.setLbAWriter(rs.getString("REF_WRITER"));
//				vo.setLbADate(rs.getString("REF_WRITE_DATE"));
//				vo.setLbACode(rs.getString("SEBJECT_CODE"));
//				volist.add(vo);		
//				}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return volist;
//	}
}

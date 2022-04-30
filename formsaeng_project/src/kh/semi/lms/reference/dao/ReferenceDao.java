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
	
	public int ReferenceinsertBoard(Connection conn, ReferenceVo vo) {
		int result = 0;
		String code = vo.getLbACode();
		String sql = "INSERT INTO REFERENCE(REF_NO, REF_TITLE, REF_CONTENT, REF_WRITE, REF_WRITE_DATE, SUBJECT_CODE"
				+ "VALUES(SEQ_REF_NO.NEXTVAL,?, ?, ?, DEFAULT, ?)"; 
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
	public ArrayList<ReferenceVo> ReferenceBoardlist(Connection conn){
		ArrayList<ReferenceVo> volist = null;
		
		String sql = "select * from reference";
				
				
				
				
				
//				"select REF_NO,"
//				+"REF_TITLE,"
//				+"REF_WRITER,"
//				+"TO_CHAR(REF_WRITE_DATE,'YYYY_MM_DD') REF_WRITE_DATE,"
//				+"SUBJECT_CODE"
//				+"FROM REFERENCE";
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
				vo.setLbACode(rs.getString("SUBJECT_CODE"));
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
	public int ReferencedeleteBoard(Connection conn, ReferenceVo vo) {
		int result = 0;
		String sql = "DELETE REFERENCE WHERE REF_NO=?";
		
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getLbAno());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
		
		return result;
	}
	public ReferenceVo detailBoard(Connection conn, int lbAno) {
		ReferenceVo result = null;

		String sql = "select REF_TITLE, REF_CONTENT from REFERENCE where REF_NO=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lbAno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
			ReferenceVo vo = new ReferenceVo();
			vo.setLbATitle(rs.getString("REF_Title"));
			vo.setLbAContent(rs.getString("REF_Content"));
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

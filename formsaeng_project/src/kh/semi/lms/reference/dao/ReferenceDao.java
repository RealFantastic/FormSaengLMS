package kh.semi.lms.reference.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.lms.asg.model.vo.AsgListVo;
import kh.semi.lms.reference.vo.ReferenceVo;


public class ReferenceDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public int ReferenceinsertBoard(Connection conn, ReferenceVo vo) {
		int result = 0;
		String write = "아무개";
		String code = "c0101";//vo.getLbACode();
		String sql = "INSERT INTO REFERENCE(REF_NO, REF_TITLE, REF_CONTENT, REF_WRITER, REF_WRITE_DATE, SUBJECT_CODE)"
				+ "VALUES(SEQ_REFERENCE_NO.nextval,?, ?, ?, default, 'M0101')"; 
//		Connection conn = JdbcDbcp.getConnection();
//		try {
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(sql);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close(rs);
//				close(stmt);
//			}
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getLbATitle());
			pstmt.setString(2, vo.getLbAContent());
			pstmt.setString(3, write);
			//pstmt.setString(4, code);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				return result;
	}
	public ArrayList<ReferenceVo> ReferenceBoardlist(Connection conn){
		ArrayList<ReferenceVo> volist = null;
		
		String sql = "select * from reference";
				
				
				
				
				
//				"select REF_NO,"
//				+"REF_TITLE,"
//				+"REF_WRITER,"
//				+"REF_CONTENT,"
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
	public int refdeleteBoard(Connection conn, int[] delist) {
		
		String sql="DELETE FROM REFERENCE WHERE REF_NO = ?";
		int cnt = 0;
		try {
		    // then obtain an Array filled with the content below
			
			for(int i =0; i<delist.length ; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, delist[i]);
				cnt += pstmt.executeUpdate();
				
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
	public ReferenceVo detailBoard(Connection conn, int lbAno) {
		ReferenceVo vo = null;

		String sql = "select REF_NO, REF_TITLE, REF_CONTENT from REFERENCE"
					+ " where REF_NO=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lbAno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo= new ReferenceVo();
				vo.setLbAno(rs.getInt(1));
				vo.setLbATitle(rs.getString(2));
				vo.setLbAContent(rs.getString(3));}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return vo;

	}
	public int multeDelet(Connection conn, String[] refdelno) {
		int result = 0;
		int cnt = 0;
		String sql = "DELETE FROM REFERENCE WHERE REF_NO=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(int i=0; i<refdelno.length; i++) {
				pstmt.setString(1, refdelno[i]);
				
				result += pstmt.executeUpdate();
			}
			
			//모아둔 쿼리 실행 끝나면 커밋
			if(refdelno.length==result) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
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
	public ArrayList<ReferenceVo> ReferenceBoardlist(Connection conn,int startRnum,int endRnum) {
		ArrayList<ReferenceVo> volist = null;
		
		String sql = "select * from"
                + " (SELECT rownum r, t1.* FROM "
                + " (SELECT REF_NO,REF_TITLE,REF_WRITER,TO_CHAR(REF_WRITE_DATE, 'YYYY-MM-DD') REF_WRITE_DATE,REF_CONTENT,SUBJECT_CODE "
                + " FROM REFERENCE a ORDER BY REF_NO DESC,REF_WRITE_DATE DESC)t1)"
                + " where r between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);
			pstmt.setInt(2, endRnum);
			rs = pstmt.executeQuery();
			
				volist = new ArrayList<ReferenceVo>();
				while(rs.next()) {
				ReferenceVo vo = new ReferenceVo();
				vo.setLbAno(rs.getInt("REF_NO"));
				vo.setLbATitle(rs.getString("REF_TITLE"));
				vo.setLbAContent(rs.getString("REF_CONTENT"));
				vo.setLbAWriter(rs.getString("REF_WRITER"));	
				vo.setLbADate(rs.getString("REF_WRITE_DATE"));
				vo.setLbACode(rs.getString("SUBJECT_CODE"));
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
	public int countListBoard(Connection conn) {
		int result = 0;
		String sql = "select count(*) from REFERENCE";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	
}

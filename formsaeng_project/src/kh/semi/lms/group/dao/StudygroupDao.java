package kh.semi.lms.group.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kh.semi.lms.group.vo.StudyGroupVo;



public class StudygroupDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public ArrayList<StudyGroupVo> StudyGrouplist(Connection conn){
		ArrayList<StudyGroupVo> volist = null;
		
		String sql = "SELECT TB1.*,SUBJECT_NAME "
				+ "FROM (SELECT ES.ID, SUBJECT_CODE, NAME FROM ENROLLMENT_STUDENT ES "
				+ "        JOIN MEMBER ON ES.ID = MEMBER.ID) TB1 "
				+ "JOIN SUBJECT ON TB1.SUBJECT_CODE = SUBJECT.SUBJECT_CODE "
				+ "WHERE TB1.SUBJECT_CODE = 'M0101' "; //추후 SUBJECT_CODE = ? 변경
				
		try {		
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			volist	 = new ArrayList<StudyGroupVo>();
			while(rs.next()) {
				StudyGroupVo vo = new StudyGroupVo();
				vo.seteId(rs.getString("ID"));
				vo.setsCode(rs.getString("SUBJECT_CODE"));
				vo.setmName(rs.getString("NAME"));
				vo.setsName(rs.getString("SUBJECT_NAME"));
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


}

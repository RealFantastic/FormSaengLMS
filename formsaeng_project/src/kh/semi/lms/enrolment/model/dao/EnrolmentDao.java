package kh.semi.lms.enrolment.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import kh.semi.member.model.vo.MemberVo;

public class EnrolmentDao {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int applySubject(MemberVo vo, String[] subCode, Connection conn) {
		int result = 0;
		
		String sql = "INSERT INTO ENROLLMENT_STUDENT VALUES	(?,?)";
		
		try {
			for(int i = 0; i< subCode.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, subCode[i]);
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
		}
		
		System.out.println("쿼리 결과로 인서트된 과묵 개수 : " + result);

		
		return result;
	}
}

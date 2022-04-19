package kh.semi.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;
import kh.semi.member.model.vo.MemberVo;

public class MemberDao {
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
	
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result = null;
		
		String sql = "select * from member where id=? and pwd=?";
		System.out.println(vo);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				System.out.println("메세지 하나");
				result = vo;
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
}

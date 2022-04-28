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
	
	// 로그인 - 관리자/교수/학생
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
	
	// 멤버 정보 조회 (마이페이지) 교수/학생
	public MemberVo readMember(Connection conn, MemberVo vo) {
		MemberVo result = null;
		String sql = "select m.name, m.email, m.address, m.pnum, d.dept_name from member m join department d using (dept_code) where id=? and pwd=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setAddress(rs.getString("address"));
				vo.setPnum(rs.getString("pnum"));
				vo.setDeptName(rs.getString("dept_name"));
				System.out.println(vo);
				
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
	
	// 멤버 정보 수정 (마이페이지) 교수/학생
	public int updateMember(Connection conn, MemberVo vo) {
		int result = 0;
		
		String sql = "update member set address=?, pnum=? where id=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAddress());
			pstmt.setString(2, vo.getPnum());
			pstmt.setString(3, vo.getId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		return result;
	}
	
	//학번 찾기
		public MemberVo findId(Connection conn, MemberVo vo) {
			MemberVo result = null;
			
			String sql = "SELECT ID FROM MEMBER WHERE NAME = ? AND EMAIL=?";
			
			System.out.println(vo);
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getEmail());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo.setId(rs.getString("id"));
				}
				
				result = vo;		
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(result);
			
			return result;
		}
	
	
	
	
	
}

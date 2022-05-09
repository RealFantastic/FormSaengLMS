package kh.semi.member.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
				vo.setDeptCode(rs.getString("dept_code"));
				System.out.println("login:" + vo);
				
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
	
	// 연락처 수정 (마이페이지) 교수/학생
	public int updatePnum(Connection conn, MemberVo vo) {
		int result = 0;
		
		String sql = "update member set pnum=? where id=? and pwd=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPnum());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			System.out.println("dao:"+vo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		return result;
	}
	// 주소 수정 (마이페이지) 교수/학생
	public int updateAddress(Connection conn, MemberVo vo) {
		int result = 0;
		
		String sql = "update member set address=? where id=? and pwd=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getAddress());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			System.out.println("dao:"+vo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		return result;
	}
	// 이메일 수정 (마이페이지) 교수/학생
	public int updateEmail(Connection conn, MemberVo vo) {
		int result = 0;
		
		String sql = "update member set email=? where id=? and pwd=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			System.out.println("dao:"+vo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(pstmt);
		}
		return result;
	}
	
	// 멤버 비밀번호 수정 (마이페이지) 교수/학생
	public int updatePwd(Connection conn, MemberVo vo) {
		int result = 0;
		
		String sql = "update member set pwd=? where id=?";
		try { 
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getId());

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
					result = new MemberVo();
					result.setId(rs.getString("id"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(stmt);
			}
			
			System.out.println(result);
			
			return result;
		}
	//학과별 교수 알아내기
		public ArrayList<MemberVo> selectPf(Connection conn, MemberVo vo) {
			ArrayList<MemberVo> result = null;
			
			String sql = "SELECT * FROM MEMBER WHERE DEPT_CODE = ? AND ID LIKE 'P%'";
			
			try {
				result = new ArrayList<MemberVo>();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getDeptCode());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					do {
						MemberVo mvo = new MemberVo();
						mvo.setId(rs.getString("id"));
						mvo.setName(rs.getString("name"));
						
						System.out.println(mvo);
						result.add(mvo);
						
					}while(rs.next());
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			System.out.println(vo.getDeptCode() + "의 찾은 교수목록 : " + result);
			
			
			
			return result;
		}
	
		//비밀번호 찾기
			public MemberVo findPassword(Connection conn, String name, String id) {
				MemberVo result = null;
				
				String sql = "SELECT ID,PWD,NAME,EMAIL FROM MEMBER WHERE ID=? AND NAME = ?";
				
				System.out.println("dao 도착 직후 파라미터 : " + id + " " + name);
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, name);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						result = new MemberVo();
						result.setId(rs.getString("id"));
						result.setPwd(rs.getString("pwd"));
						result.setName(rs.getString("name"));
						result.setEmail(rs.getString("email"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rs);
					close(stmt);
				}
				
				System.out.println("dao 쿼리이후 member 정보 확인값 : " + result);
				
				return result;
			}
			
	
	
	
}


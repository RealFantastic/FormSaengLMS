package kh.semi.message.model.dao;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kh.semi.message.model.vo.MessageVo;

public class MessageDao {

	private PreparedStatement pstmt= null;
	private Statement stmt= null;
	private ResultSet rs= null;
	
	
	//받은 메시지함
	public ArrayList<MessageVo> receive(Connection conn, String loginId){
		ArrayList<MessageVo> result=null;
		
		String sql="select * from message where recevler =? order by msg_date desc";
//		recevier=세션에 저장된 id
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			result=new ArrayList<MessageVo>();
			
			while(rs.next()) {
				MessageVo vo=new MessageVo();
				
				vo.setMsgNo(rs.getInt("mSG_NO"));
				vo.setMsgTitle(rs.getString("mSG_TITLE"));
				vo.setMsgContent(rs.getString("mSG_CONTENT"));
				vo.setMsgDate(rs.getString("mSG_DATE"));
				vo.setRecevier(rs.getString("rECEVIER"));
				vo.setSender(rs.getString("sENDER"));

				System.out.println("msgVO : "+vo);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("msgDAOresult : "+result);
		return result;
	}
	
	//보낸 메시지함
	public ArrayList<MessageVo> send(Connection conn, String loginId){
		ArrayList<MessageVo> result=null;
		
		String sql="SELECT  * FROM MESSAGE WHERE SENDER = ? order by msg_date desc";
//		 SENDER 세션에 저장된  ID
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs=pstmt.executeQuery();
			result=new ArrayList<MessageVo>();
			
			while(rs.next()) {
				MessageVo vo=new MessageVo();
				
				vo.setMsgNo(rs.getInt("mSG_NO"));
				vo.setMsgTitle(rs.getString("mSG_TITLE"));
				vo.setMsgContent(rs.getString("mSG_CONTENT"));
				vo.setMsgDate(rs.getString("mSG_DATE"));
				vo.setRecevier(rs.getString("rECEVIER"));
				vo.setSender(rs.getString("sENDER"));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
		
	}
	
	// 메시지 보내기
	public int write(Connection conn, MessageVo vo) {
		int result=0;
		
		String sql="insert into message(MSG_NO, MSG_TITLE, MSG_CONTENT, MSG_DATE, RECEVIER, SENDER)"+"values(SEQ_MSG_NO.nextval,?,?,default,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMsgTitle());
			pstmt.setString(2, vo.getMsgContent());
			pstmt.setString(3, vo.getRecevier());
			pstmt.setString(4, vo.getSender());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	
	
	
}

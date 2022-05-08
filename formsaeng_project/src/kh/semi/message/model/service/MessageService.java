package kh.semi.message.model.service;

import static kh.semi.lms.common.jdbc.JdbcDbcp.*;

import java.sql.Connection;
import java.util.ArrayList;


import kh.semi.member.model.vo.MemberVo;
import kh.semi.message.model.dao.MessageDao;
import kh.semi.message.model.vo.MessageVo;

public class MessageService {

	//받은 메시지함
	public ArrayList<MessageVo> receive(String loginId){
		Connection conn = getConnection();
		
		ArrayList<MessageVo> result=null;
		
		result=new MessageDao().receive(conn, loginId);
		
		close(conn);
		return result;
	}
	
	//보낸 메시지함
	public ArrayList<MessageVo> send(String loginId){
		Connection conn=getConnection();
		
		ArrayList<MessageVo> result=null;
		
		result=new MessageDao().send(conn, loginId);
		
		close(conn);
		return result;
	}
	
	//메시지 보내기
	public int write(MessageVo vo) {
		int result=0;
		
		Connection conn=getConnection();
		result=new MessageDao().write(conn, vo);
		
		return result;
	}
	
	//받는사람 찾기
	public ArrayList<MemberVo> reciplent(String reqName){
		System.out.println("DAOreqName : "+reqName);
		Connection conn=getConnection();
		ArrayList<MemberVo> volist=new MessageDao().reciplent(conn, reqName);
		close(conn);
		System.out.println("volist DAO: "+volist);
		return volist;
	}
	
}

package kh.semi.board.model.vo;

import java.sql.Timestamp;

public class CommentVo {
	public int CNo;
	public String CWriter;
	public Timestamp CDate;
	public String CContent;
	public String Id;
	public int BANo;
	
	@Override
	public String toString() {
		return "CommentVo [CNo=" + CNo + ", CWriter=" + CWriter + ", CDate=" + CDate + ", CContent=" + CContent
				+ ", Id=" + Id + ", BANo=" + BANo + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public int getCNo() {
		return CNo;
	}

	public void setCNo(int cNo) {
		CNo = cNo;
	}

	public String getCWriter() {
		return CWriter;
	}

	public void setCWriter(String cWriter) {
		CWriter = cWriter;
	}

	public Timestamp getCDate() {
		return CDate;
	}

	public void setCDate(Timestamp cDate) {
		CDate = cDate;
	}

	public String getCContent() {
		return CContent;
	}

	public void setCContent(String cContent) {
		CContent = cContent;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public int getBANo() {
		return BANo;
	}

	public void setBANo(int bANo) {
		BANo = bANo;
	} 
	
	
	
	
}

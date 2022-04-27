package kh.semi.lms.asg.model.vo;

import java.sql.Timestamp;

public class AsgCommentVo {
	public int cNo;
	public String cWriter;
	public Timestamp cDate;
	public String cContent;
	public String id;
	public int bANo;
	
	@Override
	public String toString() {
		return "CommentVo [cNo=" + cNo + ", cWriter=" + cWriter + ", cDate=" + cDate + ", cContent=" + cContent
				+ ", id=" + id + ", bANo=" + bANo + "]";
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcWriter() {
		return cWriter;
	}

	public void setcWriter(String cWriter) {
		this.cWriter = cWriter;
	}

	public Timestamp getcDate() {
		return cDate;
	}

	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getbANo() {
		return bANo;
	}

	public void setbANo(int bANo) {
		this.bANo = bANo;
	}
	
	
	
	
	
}

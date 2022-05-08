package kh.semi.lms.asg.model.vo;


public class AsgCommentVo {
	public int cNo;
	public String cWriter;
	public String cDate;
	public String cContent;
	public String id;
	public int bANo;
	
	//생성자
	public AsgCommentVo() {
		super();
	}
	
	//전체 생성자
	public AsgCommentVo(int cNo, String cWriter, String cDate, String cContent, String id, int bANo) {
		super();
		this.cNo = cNo;
		this.cWriter = cWriter;
		this.cDate = cDate;
		this.cContent = cContent;
		this.id = id;
		this.bANo = bANo;
	}
	
	//게터&세터
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

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
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

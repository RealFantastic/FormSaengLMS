package kh.semi.lms.asg.model.vo;

import java.sql.Timestamp;
import java.util.ArrayList;



public class AsgListVo {
	private int bANo;
	private String bATitle;
	private String bAWriter;
	private String bADate;
	private String bAContent;
	private String id;
	private int reCommentCnt;
	private ArrayList<AsgCommentVo> reVolist;
	
	public AsgListVo() {
		super();
	}
	
	

	public AsgListVo(String bATitle, String bAContent) {
		super();
		this.bATitle = bATitle;
		this.bAContent = bAContent;
	}

	


	public AsgListVo(int bANo, String bATitle, String bAWriter, String bADate, String bAContent, String id,
			int reCommentCnt) {
		super();
		this.bANo = bANo;
		this.bATitle = bATitle;
		this.bAWriter = bAWriter;
		this.bADate = bADate;
		this.bAContent = bAContent;
		this.id = id;
		this.reCommentCnt = reCommentCnt;
	}



	@Override
	public String toString() {
		return "BoardVo [bANo=" + bANo + ", bATitle=" + bATitle + ", bAWriter=" + bAWriter + ", bADate=" + bADate
				+ ", bAContent=" + bAContent + ", id=" + id + ", reCommentCnt=" + reCommentCnt + ", reVolist="
				+ reVolist + "]";
	}

	public int getbANo() {
		return bANo;
	}

	public void setbANo(int bANo) {
		this.bANo = bANo;
	}

	public String getbATitle() {
		return bATitle;
	}

	public void setbATitle(String bATitle) {
		this.bATitle = bATitle;
	}

	public String getbAWriter() {
		return bAWriter;
	}

	public void setbAWriter(String bAWriter) {
		this.bAWriter = bAWriter;
	}

	public String getbADate() {
		return bADate;
	}

	public void setbADate(String bADate) {
		this.bADate = bADate;
	}

	public String getbAContent() {
		return bAContent;
	}

	public void setbAContent(String bAContent) {
		this.bAContent = bAContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getReCommentCnt() {
		return reCommentCnt;
	}

	public void setReCommentCnt(int reCommentCnt) {
		this.reCommentCnt = reCommentCnt;
	}

	public ArrayList<AsgCommentVo> getReVolist() {
		return reVolist;
	}

	public void setReVolist(ArrayList<AsgCommentVo> reVolist) {
		this.reVolist = reVolist;
	}
	
	
	
}

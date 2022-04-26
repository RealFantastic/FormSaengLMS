package kh.semi.board.model.vo;

import java.sql.Timestamp;
import java.util.ArrayList;



public class BoardVo {
	private int bANo;
	private String bATitle;
	private String bAWriter;
	private String bADate;
	private String bAContent;
	private String id;
	private int reCommentCnt;
	private ArrayList<CommentVo> reVolist;
	
	public BoardVo() {
		super();
	}
	
	

	public BoardVo(String bATitle, String bAContent) {
		super();
		this.bATitle = bATitle;
		this.bAContent = bAContent;
	}

	


	public BoardVo(int bANo, String bATitle, String bAWriter, String bADate, String bAContent, String id,
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

	public ArrayList<CommentVo> getReVolist() {
		return reVolist;
	}

	public void setReVolist(ArrayList<CommentVo> reVolist) {
		this.reVolist = reVolist;
	}
	
	
	
}

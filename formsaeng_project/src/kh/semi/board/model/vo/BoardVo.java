package kh.semi.board.model.vo;

import java.sql.Timestamp;
import java.util.ArrayList;



public class BoardVo {
	public int BANo;
	public String BATitle;
	public String BAWriter;
	public Timestamp BADate;
	public String BAContent;
	public String Id;
	private int reCommentCnt;
	private ArrayList<CommentVo> reVolist;
	
	public BoardVo() {
		super();
	}

	public BoardVo(String bATitle, String bAContent) {
		super();
		BATitle = bATitle;
		BAContent = bAContent;
	}

	public BoardVo(int bANo, String bATitle, String bAWriter, Timestamp bADate, String bAContent, String id,
			int reCommentCnt) {
		super();
		BANo = bANo;
		BATitle = bATitle;
		BAWriter = bAWriter;
		BADate = bADate;
		BAContent = bAContent;
		Id = id;
		this.reCommentCnt = reCommentCnt;
		
	}

	@Override
	public String toString() {
		return "BoardVo [BANo=" + BANo + ", BATitle=" + BATitle + ", BAWriter=" + BAWriter + ", BADate=" + BADate
				+ ", BAContent=" + BAContent + ", Id=" + Id + ", reCommentCnt=" + reCommentCnt + ", reVolist="
				+ reVolist + "]";
	}

	public int getBANo() {
		return BANo;
	}

	public void setBANo(int bANo) {
		BANo = bANo;
	}

	public String getBATitle() {
		return BATitle;
	}

	public void setBATitle(String bATitle) {
		BATitle = bATitle;
	}

	public String getBAWriter() {
		return BAWriter;
	}

	public void setBAWriter(String bAWriter) {
		BAWriter = bAWriter;
	}

	public Timestamp getBADate() {
		return BADate;
	}

	public void setBADate(Timestamp bADate) {
		BADate = bADate;
	}

	public String getBAContent() {
		return BAContent;
	}

	public void setBAContent(String bAContent) {
		BAContent = bAContent;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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

package kh.semi.notice.vo;

import java.sql.Timestamp;

public class NoticeVo {
	private int boardNoticeNo; //공지사항 번호
	private String boardNoticeTitle; //공지사항 제목
	private String boardNoticeContent; //공지사항 내용
	private String boardNoticeWriter; //공지사항 작성자
	private String boardNoticeDate; //공지사항 작성일자
	
	
	
	public NoticeVo() {
		super();
	}

	public NoticeVo(int boardNoticeNo,String boardNoticeTitle,String boardNoticeContent,String boardNoticeWriter,String boardNoticeDate) {
		super();
		this.boardNoticeNo=boardNoticeNo;
		this.boardNoticeTitle=boardNoticeTitle;
		this.boardNoticeContent=boardNoticeContent;
		this.boardNoticeWriter=boardNoticeWriter;
		this.boardNoticeDate=boardNoticeDate;
	}
	
	@Override
	public String toString() {
		return "NoticeVo [boardNoticeNo="+boardNoticeNo+", boardNoticeTitle="+boardNoticeTitle+", boardNoticeContent="+boardNoticeContent+
				", boardNoticeWriter="+boardNoticeWriter+", boardNoticeDate="+boardNoticeDate+"]";
	}

	public int getBoardNoticeNo() {
		return boardNoticeNo;
	}

	public void setBoardNoticeNo(int boardNoticeNo) {
		this.boardNoticeNo = boardNoticeNo;
	}

	public String getBoardNoticeTitle() {
		return boardNoticeTitle;
	}

	public void setBoardNoticeTitle(String boardNoticeTitle) {
		this.boardNoticeTitle = boardNoticeTitle;
	}

	public String getBoardNoticeContent() {
		return boardNoticeContent;
	}

	public void setBoardNoticeContent(String boardNotiContent) {
		this.boardNoticeContent = boardNotiContent;
	}

	public String getBoardNoticeWriter() {
		return boardNoticeWriter;
	}

	public void setBoardNoticeWriter(String boardNoticeWriter) {
		this.boardNoticeWriter = boardNoticeWriter;
	}

	public String getBoardNoticeDate() {
		return boardNoticeDate;
	}

	public void setBoardNoticeDate(String boardNoticeDate) {
		this.boardNoticeDate = boardNoticeDate;
	}

	
	
	
}

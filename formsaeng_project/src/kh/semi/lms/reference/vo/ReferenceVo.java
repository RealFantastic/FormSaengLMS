package kh.semi.lms.reference.vo;

public class ReferenceVo {
	private int lbAno; //강의자료실 번호임
	private String lbATitle; //강의자료실 제목임
	private String lbACotent; //강의자료실 내용
	private String lbAWriter; //강의자료실 글쓴이
	private String lbADate; //강의자료실 날짜
	private String lbACode; //강의자료실 강의코드
	
	public ReferenceVo() {
		super();
	}
	public ReferenceVo(int lbAno, String lbATitle, String lbAContent, String lbAWriter, String lbADate, String lbAcode, String lbACode) {
		super();
		this.lbAno = lbAno;
		this.lbATitle = lbATitle;
		this.lbACotent = lbAContent;
		this.lbAWriter = lbAWriter;
		this.lbADate = lbADate;
		this.lbACode = lbACode;
		
	}
	@Override
	public String toString() {
		return "LectrueBoardVo [lbAno=" + lbAno + ", lbATitle=" + lbATitle + ", lbACotent=" + lbACotent + ", lbAWriter="
				+ lbAWriter + ", lbADate=" + lbADate + ", lbACode=" + lbACode + "]";
	}
	public int getLbAno() {
		return lbAno;
	}
	public void setLbAno(int lbAno) {
		this.lbAno = lbAno;
	}
	public String getLbATitle() {
		return lbATitle;
	}
	public void setLbATitle(String lbATitle) {
		this.lbATitle = lbATitle;
	}
	public String getLbACotent() {
		return lbACotent;
	}
	public void setLbACotent(String lbACotent) {
		this.lbACotent = lbACotent;
	}
	public String getLbAWriter() {
		return lbAWriter;
	}
	public void setLbAWriter(String lbAWriter) {
		this.lbAWriter = lbAWriter;
	}
	public String getLbADate() {
		return lbADate;
	}
	public void setLbADate(String lbADate) {
		this.lbADate = lbADate;
	}
	public String getLbACode() {
		return lbACode;
	}
	public void setLbACode(String lbACode) {
		this.lbACode = lbACode;
	}
	
	
	
	

}

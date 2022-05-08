package kh.semi.lms.calendar.vo;

import java.util.Date;

public class CalendarVo {
	private int academicNo;
	private String academicName;
	private Date startDate;
	private Date endDate;

	@Override
	public String toString() {
		return "CalendarVo [academicNo=" + academicNo + ", academicName=" + academicName + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	public int getAcademicNo() {
		return academicNo;
	}
	public void setAcademicNo(int academicNo) {
		this.academicNo = academicNo;
	}
	public String getAcademicName() {
		return academicName;
	}
	public void setAcademicName(String academicName) {
		this.academicName = academicName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}


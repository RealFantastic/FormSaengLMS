package kh.semi.subject.model.vo;

public class SubjectVo {
	private String subCode;
	private String subName;
	private int courseGrade;
	private int courseSemester;
	private int courseCredit;
	private String courseClass;
	private int courseCapacity;
	private String openYN;
	private String deptCode;
	private String classType;
	private String courseDay;
	private String coursePeriod;
	
	
	@Override
	public String toString() {
		return "SubjectVo [subCode=" + subCode + ", subName=" + subName + ", courseGrade=" + courseGrade
				+ ", courseSemester=" + courseSemester + ", courseCredit=" + courseCredit + ", courseClass="
				+ courseClass + ", courseCapacity=" + courseCapacity + ", openYN=" + openYN + ", deptCode=" + deptCode
				+ ", classType=" + classType + ", courseDay=" + courseDay + ", coursePeriod=" + coursePeriod + "]";
	}
	
	
	public SubjectVo() {
		
	}
	public String getSubCode() {
		return subCode;
	}
	public String getSubName() {
		return subName;
	}
	public int getCourseGrade() {
		return courseGrade;
	}
	public int getCourseSemester() {
		return courseSemester;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public String getCourseClass() {
		return courseClass;
	}
	public int getCourseCapacity() {
		return courseCapacity;
	}
	public String getOpenYN() {
		return openYN;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public String getClassType() {
		return classType;
	}
	public String getCourseDay() {
		return courseDay;
	}
	public String getCoursePeriod() {
		return coursePeriod;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public void setCourseGrade(int courseGrade) {
		this.courseGrade = courseGrade;
	}
	public void setCourseSemester(int courseSemester) {
		this.courseSemester = courseSemester;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public void setCourseClass(String courseClass) {
		this.courseClass = courseClass;
	}
	public void setCourseCapacity(int courseCapacity) {
		this.courseCapacity = courseCapacity;
	}
	public void setOpenYN(String openYN) {
		this.openYN = openYN;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public void setCourseDay(String courseDay) {
		this.courseDay = courseDay;
	}
	public void setCoursePeriod(String coursePeriod) {
		this.coursePeriod = coursePeriod;
	}
	
	
	
	
	
	
	
}

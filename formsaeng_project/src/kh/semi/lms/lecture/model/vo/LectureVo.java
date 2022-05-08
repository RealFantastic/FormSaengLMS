package kh.semi.lms.lecture.model.vo;

public class LectureVo {
	private int lecNo;
	private int weekNo;
	private String vTitle;
	private int vLength;
	private String uploadDate;
	private String subCode;
	private String fName;
	private String fPath;
	private String cName;
	
	//생성자
	public LectureVo() {
		super();
	}

	//게터,세터
	public int getLecNo() {
		return lecNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public void setLecNo(int lecNo) {
		this.lecNo = lecNo;
	}

	public int getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(int weekNo) {
		this.weekNo = weekNo;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public int getvLength() {
		return vLength;
	}

	public void setvLength(int vLength) {
		this.vLength = vLength;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfPath() {
		return fPath;
	}

	public void setfPath(String fPath) {
		this.fPath = fPath;
	}
	
}

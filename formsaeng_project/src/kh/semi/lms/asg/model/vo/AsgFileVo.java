package kh.semi.lms.asg.model.vo;

public class AsgFileVo {
	private int fNo;
	private String fName;
	private String fPath;
	private String id;
	private int bANo;

	public AsgFileVo() {
		super();
	}

	@Override
	public String toString() {
		return "AsgFileVo [fNo=" + fNo + ", fName=" + fName + ", fPath=" + fPath + ", id=" + id + ", bANo=" + bANo
				+ "]";
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
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

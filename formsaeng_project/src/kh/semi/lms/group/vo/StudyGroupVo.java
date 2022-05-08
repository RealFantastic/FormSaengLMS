package kh.semi.lms.group.vo;

public class StudyGroupVo {
	private String eId;
	private String sCode;
	private String mName;
	private String sName;

	public StudyGroupVo() {
		super();
	}

	public StudyGroupVo(String eId, String sCode, String mName, String sName) {
		super();
		this.eId = eId;
		this.sCode = sCode;
		this.mName = mName;
		this.sName = sName;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getsCode() {
		return sCode;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "StudyGroupVo [eId=" + eId + ", sCode=" + sCode + ", mName=" + mName + ", sName=" + sName + "]";
	}
}

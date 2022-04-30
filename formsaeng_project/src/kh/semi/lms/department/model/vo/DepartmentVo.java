package kh.semi.lms.department.model.vo;

public class DepartmentVo {
	private String deptCode;
	private String deptName;
	private int deptOpacity;
	@Override
	public String toString() {
		return "DepartmentVo [deptCode=" + deptCode + ", deptName=" + deptName + ", deptOpacity=" + deptOpacity + "]";
	}
	
	
	public DepartmentVo() {
		
	}


	public DepartmentVo(String deptCode, String deptName, int deptOpacity) {
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptOpacity = deptOpacity;
	}


	public String getDeptCode() {
		return deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public int getDeptOpacity() {
		return deptOpacity;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setDeptOpacity(int deptOpacity) {
		this.deptOpacity = deptOpacity;
	}
	
	
	
	
}

package kh.semi.member.model.vo;

public class MemberVo {
	private String id;
	private String name;
	private String pwd;
	private String rnum;
	private String email;
	private String address;
	private String deptCode;
	private String pnum;
	private String deptName; // DEPARTMENT table 학과 이름


//	이름        널?       유형            
//	--------- -------- ------------- 
//	ID        NOT NULL VARCHAR2(12)  
//	NAME      NOT NULL VARCHAR2(30)  
//	PWD       NOT NULL VARCHAR2(100) 주민등록번호
//	RNUM      NOT NULL VARCHAR2(20)  
//	EMAIL     NOT NULL VARCHAR2(300) 
//	ADDRESS   NOT NULL VARCHAR2(600) 
//	DEPT_CODE NOT NULL VARCHAR2(20)  
//	PNUM      NOT NULL VARCHAR2(20)  연락처 
	
	
	public MemberVo() {}
	
	public MemberVo(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	

	public MemberVo(String id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	 

	public MemberVo(String id, String name, String email, String address, String pnum, String deptName) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.pnum = pnum;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", name=" + name + ", pwd=" + pwd + ", rnum=" + rnum + ", email=" + email
				+ ", address=" + address + ", deptCode=" + deptCode + ", pnum=" + pnum + ", deptName=" + deptName + "]";
	}

	//getter & setter
	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPwd() {
		return pwd;
	}
	
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public String getRnum() {
		return rnum;
	}
	
	
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPnum() {
		return pnum;
	}
	
	
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	
	

}

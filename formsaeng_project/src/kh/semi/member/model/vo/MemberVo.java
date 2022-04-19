package kh.semi.member.model.vo;

public class MemberVo {
	private String id;
	private String name;
	private String pwd;
//	private String rnum;
//	private String email;
	
	
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
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	
	
	
	
	
	//getter & setter
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
//	이름        널?       유형            
//			--------- -------- ------------- 
//			ID        NOT NULL VARCHAR2(12)  
//			NAME      NOT NULL VARCHAR2(30)  
//			PWD       NOT NULL VARCHAR2(100) 
//			RNUM      NOT NULL VARCHAR2(20)  
//			EMAIL     NOT NULL VARCHAR2(300) 
//			ADDRESS   NOT NULL VARCHAR2(600) 
//			DEPT_CODE NOT NULL VARCHAR2(20)  
//			PNUM      NOT NULL VARCHAR2(20)  
}

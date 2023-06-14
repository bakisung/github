package kr.or.dw.vo;

public class StudentVO {
	private String stu_id;		//학번, 아이디
	private String stu_name;	//이름
	private String stu_pwd;		//비밀번호	변경가능	
	private String stu_gender;	//성별
	private String stu_resnum;	//주민번호
	private String stu_addr;	//주소		변경가능
	private String stu_detailaddr;	//주소		변경가능
	private int stu_zipcode;	//우편번호	변경가능
	private String dept_code;		//학과코드
	private String dept_name;	//학과명
	private String stu_tel;		//전화번호	변경가능
	private String stu_email;	//이메일		
	private String stu_state;	//현재 상태 (재학, 휴학, 졸업)
	private String stu_entdate;	//입학일
	private String stu_grddate;	//졸업일
	private String auth_cd;		//권한코드(학생은 S)
	private String lec_code; 
	
	
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public String getAuth_cd() {
		return auth_cd;
	}
	public void setAuth_cd(String auth_cd) {
		this.auth_cd = auth_cd;
	}
	public String getStu_state() {
		return stu_state;
	}
	public void setStu_state(String stu_state) {
		this.stu_state = stu_state;
	}

	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_gender() {
		return stu_gender;
	}
	public void setStu_gender(String stu_gender) {
		this.stu_gender = stu_gender;
	}
	public String getStu_resnum() {
		return stu_resnum;
	}
	public void setStu_resnum(String stu_resnum) {
		this.stu_resnum = stu_resnum;
	}
	public String getStu_addr() {
		return stu_addr;
	}
	public void setStu_addr(String stu_addr) {
		this.stu_addr = stu_addr;
	}
	public int getStu_zipcode() {
		return stu_zipcode;
	}
	public void setStu_zipcode(int stu_zipcode) {
		this.stu_zipcode = stu_zipcode;
	}

	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
	public String getStu_tel() {
		return stu_tel;
	}
	public void setStu_tel(String stu_tel) {
		this.stu_tel = stu_tel;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getStu_entdate() {
		return stu_entdate;
	}
	public void setStu_entdate(String stu_entdate) {
		this.stu_entdate = stu_entdate;
	}
	public String getStu_grddate() {
		return stu_grddate;
	}
	public void setStu_grddate(String stu_grddate) {
		this.stu_grddate = stu_grddate;
	}
	public String getStu_detailaddr() {
		return stu_detailaddr;
	}
	public void setStu_detailaddr(String stu_detailaddr) {
		this.stu_detailaddr = stu_detailaddr;
	}

	
	
}

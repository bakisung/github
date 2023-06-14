package kr.or.dw.vo;

import java.util.Date;

public class AssignVO {
	private int assign_no;
	private String assign_name;
	private String assign_content;
	private Date assign_start;
	private Date assign_end;
	private String lec_code;
	private String stu_id;
	private String assign_path;
	private String lec_name;
	private Date assign_subdate;
	private String stu_name;
	private String dept_name;
	private String dept_code;
	
	
	
	
	

	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getLec_name() {
		return lec_name;
	}
	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}
	public int getAssign_no() {
		return assign_no;
	}
	public void setAssign_no(int assign_no) {
		this.assign_no = assign_no;
	}
	public String getAssign_name() {
		return assign_name;
	}
	public void setAssign_name(String assign_name) {
		this.assign_name = assign_name;
	}
	public String getAssign_content() {
		return assign_content;
	}
	public void setAssign_content(String assign_content) {
		this.assign_content = assign_content;
	}

	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getAssign_path() {
		return assign_path;
	}
	public void setAssign_path(String assign_path) {
		this.assign_path = assign_path;
	}
	public Date getAssign_start() {
		return assign_start;
	}
	public void setAssign_start(Date assign_start) {
		this.assign_start = assign_start;
	}
	public Date getAssign_end() {
		return assign_end;
	}
	public void setAssign_end(Date assign_end) {
		this.assign_end = assign_end;
	}
	public Date getAssign_subdate() {
		return assign_subdate;
	}
	public void setAssign_subdate(Date assign_subdate) {
		this.assign_subdate = assign_subdate;
	}

	
}

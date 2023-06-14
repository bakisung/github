package kr.or.dw.vo;

public class LectureVO {
	private String lec_code;	//강의코드
	private int lec_time;	//강의교시
	private int lec_hour;	//강의시간
	private String lec_day;		//강의요일
	private String lec_name;	//강의명
	private String staff_id;	//교수아이디
	private String staff_name;	//교수명
	private String lec_loc;		//강의실
	private int lec_year;		//수강년도
	private int lec_term;		//수강학기
	private String lec_div;		//구분(전공필수, 전공선택, 교양)
	private int lec_credit;		//학점
	private int lec_maxpeo;		//최대 수강인원
	private int lec_curpeo;		//현재 수강인원
	private String stu_grade;	//등급(A,B,C,D,F)
	private double stu_score;	//점수 합계
	private String stu_id;	//학생학번
	private String stu_name;	//학생이름
	private String dept_name;	//학과명
	private String dept_code;	//학과코드
	private String plan_path; 	//계획안파일 경로
	private String search;
	
	
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getPlan_path() {
		return plan_path;
	}
	public void setPlan_path(String plan_path) {
		this.plan_path = plan_path;
	}
	public String getLec_code() {
		return lec_code;
	}
	public void setLec_code(String lec_code) {
		this.lec_code = lec_code;
	}
	public int getLec_time() {
		return lec_time;
	}
	public void setLec_time(int lec_time) {
		this.lec_time = lec_time;
	}
	public String getLec_day() {
		return lec_day;
	}
	public void setLec_day(String lec_day) {
		this.lec_day = lec_day;
	}
	public String getLec_name() {
		return lec_name;
	}
	public void setLec_name(String lec_name) {
		this.lec_name = lec_name;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getLec_loc() {
		return lec_loc;
	}
	public void setLec_loc(String lec_loc) {
		this.lec_loc = lec_loc;
	}
	public int getLec_year() {
		return lec_year;
	}
	public void setLec_year(int lec_year) {
		this.lec_year = lec_year;
	}
	public int getLec_term() {
		return lec_term;
	}
	public void setLec_term(int lec_term) {
		this.lec_term = lec_term;
	}
	public String getLec_div() {
		return lec_div;
	}
	public void setLec_div(String lec_div) {
		this.lec_div = lec_div;
	}
	public int getLec_credit() {
		return lec_credit;
	}
	public void setLec_credit(int lec_credit) {
		this.lec_credit = lec_credit;
	}
	public int getLec_maxpeo() {
		return lec_maxpeo;
	}
	public void setLec_maxpeo(int lec_maxpeo) {
		this.lec_maxpeo = lec_maxpeo;
	}
	public int getLec_curpeo() {
		return lec_curpeo;
	}
	public void setLec_curpeo(int lec_curpeo) {
		this.lec_curpeo = lec_curpeo;
	}
	public String getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}
	public double getStu_score() {
		return stu_score;
	}
	public void setStu_score(double stu_score) {
		this.stu_score = stu_score;
	}
	public int getLec_hour() {
		return lec_hour;
	}
	public void setLec_hour(int lec_hour) {
		this.lec_hour = lec_hour;
	}
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
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	

}

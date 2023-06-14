package kr.or.dw.user.vo;

import java.sql.Date;

public class UserVO {
	
	private int user_no;
	private String email;
	private String pass;
	private String nick;
	private String name;
	private String bir;
	private String gender;
	private String pic_path;
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBir() {
		return bir;
	}
	public void setBir(String bir) {
		this.bir = bir;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}
	
	
	
	
	
}

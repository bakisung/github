package kr.or.dw.board.vo;

import java.sql.Date;

public class BoardVO {
	private int bd_no;
	private String bd_title;
	private int user_no;
	private String nick;
	private String bd_content;
	private Date bd_wdt;
	private int bd_hit;
	private int bd_like;
	private String gb_del;
	private String pic_path;
	
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getBd_content() {
		return bd_content;
	}
	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}
	public Date getBd_wdt() {
		return bd_wdt;
	}
	public void setBd_wdt(Date bd_wdt) {
		this.bd_wdt = bd_wdt;
	}
	public int getBd_hit() {
		return bd_hit;
	}
	public void setBd_hit(int bd_hit) {
		this.bd_hit = bd_hit;
	}
	public int getBd_like() {
		return bd_like;
	}
	public void setBd_like(int bd_like) {
		this.bd_like = bd_like;
	}
	public String getGb_del() {
		return gb_del;
	}
	public void setGb_del(String gb_del) {
		this.gb_del = gb_del;
	}
	public String getPic_path() {
		return pic_path;
	}
	public void setPic_path(String pic_path) {
		this.pic_path = pic_path;
	}
}
package kr.or.dw.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {

	private String id        ;
	private String pwd       ;
	private String email     ;
	private String picture   ;
	private int enabled   ;
	private Date regdate   ;
	private String phone     ;
	private String name      ;
	private String register  ;
	private String address   ;
	private String authority ;
	
	public MemberVO() {};
	
	public MemberVO(String id, String pwd, String name, String phone, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
}

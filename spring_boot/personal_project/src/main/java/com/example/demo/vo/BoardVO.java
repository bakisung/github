package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	private String board_no     ;
	private String user_number  ;
	private String title        ;
	private String content      ;
	private String writer       ;
	private Date regdate      	;
	private int enabled     	;
	private String files        ;
	private String file_name    ;
	private Date update_date   	;
	private String updater      ;
	private int view_count		;
	private int like_count		;
	
}

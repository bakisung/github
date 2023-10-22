package kr.or.dw.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data 	// 게터, 세터, 이퀄스, 투스트링 메서드를 자동으로 생성해준다.
public class MemberVO {
	
	private String USER_NUMBER;
	private String USER_ID;
	private String USER_PASSWORD;
	private String USER_NAME;
	private String USER_EMAIL;
	private String USER_PHONE;
	private String USER_ADDRESS;
	private int USER_PROGRESS;
	private String USER_AUTHORITY;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date USER_REGDATE;
	
}

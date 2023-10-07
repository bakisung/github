package kr.or.dw.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data 	// 게터, 세터, 이퀄스, 투스트링 메서드를 자동으로 생성해준다.
public class MemberVO {
	
	private String member_id;
	private String member_password;
	private String member_name;
	private String member_authority;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date member_create_date;
	private int member_enabled;
	
}

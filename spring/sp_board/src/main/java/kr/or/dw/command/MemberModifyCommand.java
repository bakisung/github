package kr.or.dw.command;

import org.springframework.web.multipart.MultipartFile;

import kr.or.dw.vo.MemberVO;
import lombok.Data;

@Data
public class MemberModifyCommand {
	
	private String id        ;
	private String pwd       ;
	private String email     ;
	private String phone     ;
	private String name      ;
	private String register  ;
	private String authority ;
	private String oldPicture;
	private String uploadPicture;
	private MultipartFile picture;
	
	public MemberVO toParseMember() {
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setPhone(phone.replace("-", ""));
		member.setEmail(email);
		member.setAuthority(authority);

		return member;
	}
	
}

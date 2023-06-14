package kr.or.dw.user.dao;

import kr.or.dw.user.vo.UserVO;

public interface IUserDao {
	
	public String getUserNick(String nick);	// 닉네임을 조회하는 메서드

	public int insertUser(UserVO vo);	// 회원 정보를 등록하는 메서드

	public UserVO loginUser(String email);	// 회원 정보를 조회하는 메서드

	public void updateUserPicPath(UserVO vo);	// 회원의 프로필 사진 경로를 수정하는 메서드
	
}

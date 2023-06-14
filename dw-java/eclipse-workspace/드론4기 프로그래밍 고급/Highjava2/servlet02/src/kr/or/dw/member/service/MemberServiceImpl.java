package kr.or.dw.member.service;

import java.util.List;

import kr.or.dw.member.dao.IMemberDao;
import kr.or.dw.member.dao.MemberDaoImpl;
import kr.or.dw.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	// DAO 객체 변수 생성
	private IMemberDao dao;
	private static MemberServiceImpl service;
	
	public static MemberServiceImpl getInstance(){
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	// 생성자
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String mem_id) {
		return dao.getMemberCount(mem_id);
	}

	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public MemberVO getMember(String mem_id) {
		return dao.getMember(mem_id);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}

}

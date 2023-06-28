package kr.or.dw.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dw.dao.AttachDAO;
import kr.or.dw.dao.PdsDAO;
import kr.or.dw.vo.AttachVO;
import kr.or.dw.vo.PdsVO;

@Service
public class PdsServiceImpl implements PdsSerivce{
	
	@Autowired
	private PdsDAO pdsDAO;
	
	@Autowired
	private AttachDAO attachDAO;
	
	@Override
	public void regist(PdsVO pds) throws SQLException {
		int pno = 0;
		pdsDAO.insertPds(pds);
		for(AttachVO attach : pds.getAttachList()) {
			attach.setPno(pds.getPno());
			attach.setAttacher(pds.getWriter());
			attachDAO.insertAttach(attach);
		}
		
	}

}

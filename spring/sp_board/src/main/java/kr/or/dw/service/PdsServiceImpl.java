package kr.or.dw.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dw.command.PageMaker;
import kr.or.dw.command.SearchCriteria;
import kr.or.dw.dao.AttachDAO;
import kr.or.dw.dao.PdsDAO;
import kr.or.dw.vo.AttachVO;
import kr.or.dw.vo.PdsVO;

@Service
public class PdsServiceImpl implements PdsService{

	@Autowired
	private PdsDAO pdsDAO;
	
	@Autowired
	private AttachDAO attachDAO;
	
	@Override
	public void regist(PdsVO pds) throws SQLException {
		int pno = 0;
		pno = pdsDAO.insertPds(pds);
		for(AttachVO attach : pds.getAttachList()) {
			attach.setPno(pds.getPno());
			attach.setAttacher(pds.getWriter());
			attachDAO.insertAttach(attach);
		}
		
	}

	@Override
	public Map<String, Object> selectPdsList(SearchCriteria cri) throws SQLException {
		
		List<PdsVO> pdsList = null;
		
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		pdsList = pdsDAO.selectSearchPdsList(cri, rowBounds);
		
		if(pdsList != null) {
			for(PdsVO pds : pdsList) {
				pds.setAttachList(attachDAO.selectAttachByPno(pds.getPno()));
			}
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(pdsDAO.selectSearchPdsListCount(cri));
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("pdsList", pdsList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public PdsVO selectPds(int pno, String from) throws SQLException {
		if (from == null) {
			pdsDAO.increaseViewCnt(pno);
		};
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		pds.setAttachList(attachDAO.selectAttachByPno(pno));
		
		return pds;
	}

	@Override
	public void modify(PdsVO pds) throws SQLException {
		
		pdsDAO.updatePds(pds);
		
		for(AttachVO attach : pds.getAttachList()) {
			attach.setPno(pds.getPno());
			attach.setAttacher(pds.getWriter());
			attachDAO.insertAttach(attach);
		}
		
	}

	@Override
	public void remove(int pno) throws SQLException {
		attachDAO.deleteAllAttach(pno);
		
		pdsDAO.deletePds(pno);
	}
	
}




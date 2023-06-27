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
import kr.or.dw.dao.ReplyDAO;
import kr.or.dw.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public void registReply(ReplyVO reply) throws SQLException {
		replyDAO.insertReply(reply);
	}

	@Override
	public Map<String, Object> selectReplyList(int bno, SearchCriteria cri) throws SQLException {

		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<ReplyVO> replyList = replyDAO.selectPageReplyList(bno, rowBounds);
		int totalCount = replyDAO.countReply(bno);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("replyList", replyList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public void removeReply(int rno) throws SQLException {
		replyDAO.deleteReply(rno);
	}

}

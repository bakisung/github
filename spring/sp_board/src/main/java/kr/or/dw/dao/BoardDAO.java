package kr.or.dw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.BoardVO;

@Mapper
public interface BoardDAO {

	static List<BoardVO> GetBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

}

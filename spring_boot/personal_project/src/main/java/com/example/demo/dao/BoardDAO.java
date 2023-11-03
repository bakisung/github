package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.BoardVO;

@Mapper
public interface BoardDAO {

	List<BoardVO> selectBoardList() throws SQLException;

}

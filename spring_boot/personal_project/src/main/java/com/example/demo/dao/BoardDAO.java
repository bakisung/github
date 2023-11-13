package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.BoardVO;

// 2023.11.04 아래와 같은 오류가 있었다.
// interface인 dao 파일에 @mapper 어노테이션을 하였음에도 불구하고
// ServiceImpl 에서 해당 dao 파일을 찾지 못하는 이슈가 있었다.
// 구글링 결과 gradle에서 MyBatis의 버전과 맞지 않아 발생한 이슈였다.
// 하여 build.gradle 파일에서 MyBatis의 버전을 아래와 같이 다운그레이드 하였다.

// implementation group: 'org.mybatis.spring.boot', name: 'mybatis-spring-boot-starter', version: '2.3.1'

// 오류 내용
//Description:
//Field boardDAO in com.example.demo.service.BoardServiceImpl required a bean of type 'com.example.demo.dao.BoardDAO' that could not be found.
//The injection point has the following annotations:
//	- @org.springframework.beans.factory.annotation.Autowired(required=true)
//Action:
//Consider defining a bean of type 'com.example.demo.dao.BoardDAO' in your configuration.

// 다음은 참고했던 링크와 내용이다.
// https://dev-swlee.tistory.com/32

//원인분석
//실제로 Mybatis Interface를 구현하여 @Mapper 어노테이션을 삽입하면 Spring 에서 프록시 기능을 이용해 
//Mybatis 구현체를 생성해주 는 걸로 알고있으나, 해당 작업이 정상적으로 실행되지 않아 Bean NotFound 발생
//Spring에서 FactoryBean을 관리하고 등록하는 클래스인 FactoryBeanRegistrySupport 클래스에
//Mybatis Spring v3 에서는 Mapper 관련 FactoryBean이 넘어오지 않음. (첨부사진은 Mybatis Spring V2)

//정리
//결국에는 MyBatis Mapper 구현체를 정상적으로 생성하지 못하거나, 구현체를 빈에 정상적으로 등록하지 못함
//Spring Boot 버전과 연관이 있는지 확인필요
//Mybatis Mapper파일은 인터페이스 파일이므로 당연히 BeanFactory에 바로 등록은 안되겠지만,
//Mybatis Spring에서 해당 작업을 프록시 기능을 이용하여 진행하는것으로 알고있음 (이 과정 트러블슈팅 필요)

@Mapper
public interface BoardDAO {

	List<BoardVO> selectBoardList() throws SQLException;

	void insertBoard(BoardVO boardVO) throws SQLException;

	BoardVO selectBoardDetail(String board_no) throws SQLException;

}

package kr.or.dw.user.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.dw.user.vo.UserVO;
import kr.or.dw.util.BuildSqlMapClient;

public class UserDaoImpl implements IUserDao{
	
	private static UserDaoImpl dao;
	private SqlMapClient client;
	
	private UserDaoImpl() {
		client = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static UserDaoImpl getInstance() {
		if(dao == null) dao = new UserDaoImpl();
		return dao;
	}
	
	@Override
	public String getUserNick(String nick) {
		String userNick = null;
		
		try {
			userNick = (String)client.queryForObject("user.getUserNick", nick);
			System.out.println(userNick);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userNick;
	}

	@Override
	public int insertUser(UserVO vo) {
		int result = 0;
		
		try {
			result = (int) client.insert("user.insertUser", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public UserVO loginUser(String email) {
		
		UserVO vo = null;
		
		try {
			vo = (UserVO) client.queryForObject("user.loginUser", email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public void updateUserPicPath(UserVO vo) {
		try {
			client.update("user.updateUserPicPath", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

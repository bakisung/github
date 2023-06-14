package kr.or.dw.staff.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.dw.util.BuildSqlMapClient;
import kr.or.dw.vo.DateVO;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.vo.StudentVO;

public class StaffDaoImpl implements IStaffDao{
private static StaffDaoImpl dao;
	
	private SqlMapClient smc; 	//ibatis 용 SqlMapClient 객체 변수 선언
	
	private StaffDaoImpl() {
		smc = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static StaffDaoImpl getInstance() {
		if(dao == null) {
			dao = new StaffDaoImpl();
		}
		return dao;
	}

	@Override
	public StaffVO staffLogin(String staff_id) {
		StaffVO vo = null;
		try {
			vo = (StaffVO) smc.queryForObject("staff.staffLogin", staff_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public String getStaffName(String staff_id) {
		String staff_name = null;
		try {
			staff_name = (String) smc.queryForObject("staff.getStaffName", staff_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return staff_name;
	}

	@Override
	public int idEmailCheck(StaffVO staffVo) {
		int result = 0;
		try {
			result = (int) smc.queryForObject("staff.idEmailCheck", staffVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<StaffVO> getAllProfessorList(Map<String, Object> paramMap) {
		
		List<StaffVO> staVoList = null;
		
		try {
			staVoList = smc.queryForList("staff.getAllProfessorList", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staVoList;
	}

	@Override
	public List<StaffVO> getDept() {
		List<StaffVO> staVo = null;
		
		try {
			staVo = smc.queryForList("staff.getDept");
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		return staVo;
	}

	@Override
	public List<StaffVO> professorInsert(StaffVO staVo) {
		List<StaffVO> cnt = null;
		
		try {
			cnt = (List) smc.insert("staff.professorInsert", staVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int professorDelete(String id) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("staff.professorDelete", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public StaffVO getstaffInfo(String staff_id) {
		StaffVO staVo = new StaffVO();
		
		try {
			staVo = (StaffVO) smc.queryForObject("staff.getstaffInfo", staff_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return staVo;
	}

	@Override
	public int professorUpdate(StaffVO staVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("staff.professorUpdate", staVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int selectProfessorCount() {
		int totalCount = 0;
		
		try {
			totalCount = (int) smc.queryForObject("staff.selectProfessorCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}

	@Override
	public int passwordUpdat(StaffVO staffVo) {
		int result = 0;
		
		try {
			result = smc.update("staff.staffPasswordUpdate", staffVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int staffInfoUpdate(StaffVO staffVo) {
		int result = 0;
		
		try {
			result = smc.update("staff.staffInfoUpdate", staffVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<DateVO> getDatelist() {
		List<DateVO> dateList = null;
		try {
			dateList = smc.queryForList("staff.getDateList");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateList;
	}

	@Override
	public int insertDate(DateVO dateVo) {
		String result = null;
		int cnt = 0;
		try {
			result = (String) smc.insert("staff.insertDate", dateVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public DateVO getDate(DateVO yearTerm) {
		DateVO dateVo = null;
		try {
			dateVo = (DateVO) smc.queryForObject("staff.getDate", yearTerm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateVo;
	}

	@Override
	public int existDate(DateVO dateVo) {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("staff.existDate", dateVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateDate(DateVO dateVo) {
		int result = 0;
		try {
			result = smc.update("staff.updateDate", dateVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}

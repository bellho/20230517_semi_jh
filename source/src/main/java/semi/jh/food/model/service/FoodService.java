package semi.jh.food.model.service;

import static semi.jh.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import semi.jh.common.jdbc.MyBatisTemplate;
import semi.jh.food.model.dao.ProcessecFoodDao;
import semi.jh.food.model.dto.ProcessecFoodDto;

public class FoodService {
	private ProcessecFoodDao dao = new ProcessecFoodDao();
	
	public List<ProcessecFoodDto> selectListFood(String foodName) throws SQLException{
		List<ProcessecFoodDto> result = null;
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		result = dao.selectListFood(session, foodName);
		session.close();
		return result;
	}
	
	
	
	public Map<String, Object> selectListFood(int currentPage, int pageSize, String searchWord) throws SQLException {
		Connection conn = getConnection();
		int totalCnt = dao.getSearchTotalCount(conn, searchWord);
		List<ProcessecFoodDto> result = dao.selectListFood(conn, currentPage, pageSize, totalCnt, searchWord);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("foodList", result);
		return map;
	}
	
	public ProcessecFoodDto selectOneStudent(String foodCode) throws SQLException {
		Connection conn = getConnection();
		ProcessecFoodDto result = dao.selectOneFood(conn, foodCode);
		close(conn);
		return result;
	}
}

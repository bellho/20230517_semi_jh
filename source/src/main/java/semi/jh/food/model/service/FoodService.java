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
	
	public Map<String, Object> selectListFood(int currentPage, int pageSize, String searchWord) throws SQLException {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		int totalCnt = dao.getSearchTotalCount(session, searchWord);
		List<ProcessecFoodDto> result = dao.selectListFood(session, currentPage, pageSize, totalCnt, searchWord);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("foodList", result);
		return map;
	}
	
	public ProcessecFoodDto selectOneFood(String foodCode) throws SQLException {
		SqlSession session = MyBatisTemplate.getSqlSession(true);
		ProcessecFoodDto result = dao.selectOneFood(session, foodCode);
		
		return result;
	}
}

package semi.jh.food.model.service;

import static semi.jh.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import semi.jh.food.model.dao.ProcessecFoodDao;
import semi.jh.food.model.dto.ProcessecFoodDto;

public class FoodService {
	private ProcessecFoodDao dao = new ProcessecFoodDao();
	
	public List<ProcessecFoodDto> selectListFood(String foodName) throws SQLException{
		List<ProcessecFoodDto> result = null;
		Connection conn = getConnection();
		result = dao.selectListFood(conn, foodName);
		close(conn);
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
	
//	public int getTotalCount(String searchWord) throws SQLException {
//		Connection conn = getConnection();
//		int result = dao.getSearchTotalCount(conn, searchWord);
//		close(conn);
//		return result;
//	}
}

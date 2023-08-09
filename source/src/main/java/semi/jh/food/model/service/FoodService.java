package semi.jh.food.model.service;

import static semi.jh.common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import semi.jh.food.model.dao.ProcessecFoodDao;
import semi.jh.food.model.dto.ProcessecFoodDto;

public class FoodService {
	private ProcessecFoodDao dao = new ProcessecFoodDao();
	
	public List<ProcessecFoodDto> selectList() throws SQLException{
		List<ProcessecFoodDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	public List<ProcessecFoodDto> selectList(String foodName) throws SQLException{
		List<ProcessecFoodDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn, foodName);
		close(conn);
		return result;
	}
}

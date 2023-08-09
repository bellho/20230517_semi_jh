package semi.jh.food.model.dao;

import static semi.jh.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import semi.jh.food.model.dto.ProcessecFoodDto;


public class ProcessecFoodDao {

	/**
	  * @Method Name : selectList
	  * @작성일 : 2023. 8. 8.
	  * @작성자 : 1313k
	  * @변경이력 : 
	  * @Method 설명 : 검색한 결과를 list.jsp에 출력
	  * @param conn
	  * @param foodName
	  * @return
	  * @throws SQLException
	  */
	public List<ProcessecFoodDto> selectList(Connection conn, String foodName) throws SQLException{
		System.out.println("[ProcessecFoodDao slecetList]");
		List<ProcessecFoodDto> result = new ArrayList<ProcessecFoodDto>();
		String query = "SELECT food_name,"
				+ " manufacturer,"
				+ " food_date,"
				+ " food_db_category,"
				+ " food_category,"
				+ " information_source,"
				+ " calories"
				+ " FROM tb_processed_food"
				+ " where food_name like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		foodName = "%" + foodName + "%";
		System.out.println(foodName);
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, foodName);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			ProcessecFoodDto vo = new ProcessecFoodDto(
					rs.getString("food_name"), 
					rs.getString("manufacturer"),
					rs.getInt("food_date"),
					rs.getString("food_db_category"),
					rs.getString("food_category"),
					rs.getString("information_source"),
					rs.getInt("calories"));
			result.add(vo);
			//TODO dao와 dto 수정 완료
		}
		System.out.println("검색함" + foodName );
		return result;
	}

}

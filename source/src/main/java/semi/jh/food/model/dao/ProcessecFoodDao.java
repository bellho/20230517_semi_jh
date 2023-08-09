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
	  * @변경이력 : list.jsp에서 모든 데이터를 쿼리항목을 통해 불러옴
	  * @Method 설명 : 
	  * @param conn
	  * @return
	  * @throws SQLException
	  */
	public List<ProcessecFoodDto> selectList(Connection conn) throws SQLException{
		System.out.println("[ProcessecFoodDao slecetList]");
		List<ProcessecFoodDto> result = new ArrayList<ProcessecFoodDto>();
		String query = "select food_name, manufacturer, calories from tb_processed_food";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ProcessecFoodDto dto = new ProcessecFoodDto();
			dto.setFoodName(rs.getString("food_name"));
			dto.setManufacturer(rs.getString("manufacturer"));
			dto.setCalories(rs.getInt("calories"));
			result.add(dto);
		}
		return result;
	}
	
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
//	public ProcessecFoodDto selectOne (Connection conn, String foodName) throws SQLException {
//		ProcessecFoodDto result = null;
//		String query = "select food_name, manufacturer , calories from tb_processed_food where food_code = ?";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		pstmt = conn.prepareStatement(query);
//		pstmt.setString(1, foodName);
//		rs = pstmt.executeQuery();
//		if(rs.next()) {
//			result = new ProcessecFoodDto(
//					rs.getString("select food_name"), 
//					rs.getString("manufacturer"), 
//					rs.getInt("calories"));
//		}
//		System.out.println(result);
//		return result;
//	}
}

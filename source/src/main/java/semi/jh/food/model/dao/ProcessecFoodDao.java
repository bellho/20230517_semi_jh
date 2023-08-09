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
	  * @Method Name : selectListFood
	  * @작성일 : 2023. 8. 8.
	  * @작성자 : 1313k
	  * @변경이력 : 
	  * @Method 설명 : 검색한 결과를 list.jsp에 출력
	  * @param conn
	  * @param foodName
	  * @return
	  * @throws SQLException
	  */
	public List<ProcessecFoodDto> selectListFood(Connection conn, String foodName) throws SQLException{
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
	
	/**
	
	  * @Method Name : getTotalCount
	  * @작성일 : 2023. 8. 9.
	  * @작성자 : 1313k
	  * @변경이력 : 
	  * @Method 설명 :	oracle에서 count(*)함수를 이용하여 총 컬럼 개수를 리턴.
	  * 				PreparedStatement 사용시 반드시 count(*)같은 함수뒤에 별칭 사용.
	  * 				(이 메소드에서는 "cnt"사용)
	  * @param conn
	  * @return
	  */
	public int getSearchTotalCount(Connection conn, String searchWord) throws SQLException {
		System.out.println("[ProcessecFoodDao getSearchTotalCount] searchWord :" +searchWord);
		int result = 0;
		String queryTotalCnt = "select count(*) cnt from tb_processed_food"
				+ "	where food_name like ?";
		searchWord = "%" + searchWord + "%";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = conn.prepareStatement(queryTotalCnt);
		pstmt.setNString(1, searchWord);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			result = rs.getInt("cnt");
		}
		System.out.println("[getSearchTotalCount]총글개수 : " + result);
		return result;
	}
	
	public List<ProcessecFoodDto> selectListFood(Connection conn, int currentPage, int pageSize, int totalCnt, String searchWord) throws SQLException {
		System.out.println("[ProcessecFoodDao List<ProcessecFoodDto> selectListFood]");
		List<ProcessecFoodDto> result = new ArrayList<ProcessecFoodDto>();
		String query = "SELECT * "
				+ " from(select tb1.*,"
				+ " rownum rn from(SELECT food_name,"
				+ " manufacturer,"
				+ " food_date,"
				+ " food_db_category,"
				+ " food_category,"
				+ " issuer,"
				+ " calories FROM tb_processed_food"
				+ " where food_name like ?"
				+ " order by food_name desc)"
				+ "tb1)"
				+ "tb2 where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		searchWord = "%" + searchWord + "%";
		System.out.println("selectListFood : " + searchWord);
		System.out.println("총글개수:"+totalCnt);
		int startRownum = (currentPage-1)*pageSize +1;
		int endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, searchWord);
		pstmt.setInt(2, startRownum);
		pstmt.setInt(3, endRownum);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			ProcessecFoodDto vo = new ProcessecFoodDto(
					rs.getString("food_name"), 
					rs.getString("manufacturer"),
					rs.getInt("food_date"),
					rs.getString("food_db_category"),
					rs.getString("food_category"),
					rs.getString("issuer"),
					rs.getInt("calories"));
			result.add(vo);
		}
		return result;
	}
}

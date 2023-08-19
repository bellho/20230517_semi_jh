package semi.jh.food.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import semi.jh.food.model.dto.ProcessecFoodDto;


public class ProcessecFoodDao {


	
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
	public int getSearchTotalCount(SqlSession session, String searchWord) throws SQLException {
		System.out.println("[ProcessecFoodDao getSearchTotalCount] searchWord :" + searchWord);
		searchWord = "%" + searchWord + "%";
		int result = session.selectOne("foodMapper1.getSearchTotalCount",searchWord);
		return result;
	}
	
	public List<ProcessecFoodDto> selectListFood(SqlSession session, int currentPage, int pageSize, int totalCnt, String searchWord) throws SQLException {
		System.out.println("[ProcessecFoodDao List<ProcessecFoodDto> selectListFood]");
		List<ProcessecFoodDto> result = new ArrayList<ProcessecFoodDto>();

		searchWord = "%" + searchWord + "%";
		int startRownum = (currentPage-1)*pageSize +1;
		int endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", searchWord);
		map.put("startRownum", startRownum);
		map.put("endRownum", endRownum);
		
		result = session.selectList("foodMapper1.selectListFood1",map);
		
		return result;
	}
	
	public ProcessecFoodDto selectOneFood(SqlSession session, String foodCode) throws SQLException {
		ProcessecFoodDto result = session.selectOne("foodMapper1.selectOneFood2", foodCode);
		System.out.println(result);
		return result;
	}
}

package semi.jh.food.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.jh.food.model.dto.ProcessecFoodDto;
import semi.jh.food.model.service.FoodService;

/**
 * Servlet implementation class ProcessecFoodListServlet
 */
@WebServlet("/food/list")
public class FoodListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchWord = request.getParameter("searchWord");
		String pageNoStr = request.getParameter("pageNo");
		
		int currentPage = 1;
		int pageSize = 10;
		
		if(pageNoStr != null) {
			try {
				currentPage = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		FoodService service = new FoodService();
		Map<String, Object> map = null;
		try {
			map = service.selectListFood(currentPage, pageSize, searchWord);
			request.setAttribute("foodList", map.get("foodList"));// List<ProcessecFoodDto>
			
			int pageBlockSize = 5;
			int totalCnt = (Integer)map.get("totalCnt");
			int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0 : 1);
			int startPageNum = 1;

			if((currentPage%pageBlockSize) == 0) {
				startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
			} else {
				startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
			}
			int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum+pageBlockSize-1;
			request.setAttribute("totalPageNum", totalPageNum);
			request.setAttribute("startPageNum", startPageNum);
			request.setAttribute("endPageNum", endPageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalCnt", totalCnt);
			
			if(searchWord != null) {
				request.setAttribute("searchWord", searchWord);
				System.out.println("서블릿 searchWord : " + searchWord);
			}
			System.out.println("서블릿 totalCnt : " + totalCnt);
			request.getRequestDispatcher("/WEB-INF/view/food/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package semi.jh.food.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
		FoodService service = new FoodService();
		try {
			String searchWord = request.getParameter("foodName");
			List<ProcessecFoodDto> foodList = service.selectList(searchWord);
			System.out.println("서블릿" + foodList);
			request.setAttribute("searchWord", searchWord);
			request.setAttribute("foodList", foodList);
			request.getRequestDispatcher("/WEB-INF/view/food/list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

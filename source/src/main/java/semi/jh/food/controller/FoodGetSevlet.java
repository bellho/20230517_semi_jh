package semi.jh.food.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.jh.food.model.dto.ProcessecFoodDto;
import semi.jh.food.model.service.FoodService;

/**
 * Servlet implementation class FoodSelectOneListSevlet
 */
@WebServlet("/food/get")
public class FoodGetSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FoodGetSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String foodCode = request.getParameter("fno");
		FoodService service = new FoodService();
		try {
			ProcessecFoodDto vo = service.selectOneStudent(foodCode);
			request.setAttribute("fvo", vo);
			request.getRequestDispatcher("/WEB-INF/view/food/get.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}

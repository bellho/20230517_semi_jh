package semi.jh.member.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.jh.member.model.dto.MemberDto;
import semi.jh.member.model.service.MemberService;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/loginck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String brithday = request.getParameter("brithday");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int gender = Integer.parseInt(request.getParameter("gender"));
		
		MemberDto vo = new MemberDto(id, pwd, name, brithday, email, phone, gender, LocalDateTime.now());
		System.out.println("Servlet MemberVo : " + vo);
		MemberService service = new MemberService();
		int result = service.memberInsert(vo);
	}

}

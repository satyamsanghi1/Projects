package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.AdminController;

/**
 * Servlet implementation class AdminLoginSubmit
 */
@WebServlet("/AdminLoginSubmit")
public class AdminLoginSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLoginSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ResultSet rs = AdminController.loginCheck(username, password);
		
		try {

			if (rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("admin","admin");
				session.setAttribute("adminname",rs.getString(2));
			response.sendRedirect("AdminHomepage");
			} else {
				out.println("Login failed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		out.flush();
	}

}

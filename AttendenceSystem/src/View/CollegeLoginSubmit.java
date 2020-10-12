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
import Controller.CollegeController;

/**
 * Servlet implementation class CollegeLoginSubmit
 */
@WebServlet("/CollegeLoginSubmit")
public class CollegeLoginSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeLoginSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 String userid = request.getParameter("userid");
			String password = request.getParameter("password");
			ResultSet rs = CollegeController.loginCheck(userid, password);
			
			try {

				if (rs.next()) {
					HttpSession session=request.getSession();
					session.setAttribute("college","college");
					session.setAttribute("collegeid",rs.getString("collegeid"));
					session.setAttribute("collegename",rs.getString(1));
				response.sendRedirect("CollegeHomepage");
				} else {
					out.println("Login failed");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			out.flush();
	}

	

}

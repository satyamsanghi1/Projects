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

import Controller.MentorController;
import Controller.StudentController;

/**
 * Servlet implementation class StudentLoginSubmit
 */
@WebServlet("/StudentLoginSubmit")
public class StudentLoginSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLoginSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out=response.getWriter();
	        String enrollmentno = request.getParameter("rollno");
			String password = request.getParameter("password");
			ResultSet rs = StudentController.loginCheck(enrollmentno, password);
			
			try {

				if (rs.next()) {
					HttpSession session=request.getSession();
					session.setAttribute("student","student");
					session.setAttribute("studentrollno",rs.getString(1));
					session.setAttribute("studentname",rs.getString("name"));
				response.sendRedirect("StudentHomepage");
				} else {
					out.println("Login failed");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			out.flush();
	}

	

}

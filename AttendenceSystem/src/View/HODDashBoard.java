package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HODDashBoard
 */
@WebServlet("/HODDashBoard")
public class HODDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HODDashBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<h5>welcome to HOD dashboard</h5>");
		out.println("<br><br><a href='ShowTeacherRequests' target=hoddashboardshow>View Teacher Requests</a>");
		out.println("<br><br><a href='ShowRegisteredTeacher' target=hoddashboardshow>View Registered Teacher</a>");
		out.println("<br><br><a href='ShowMentorRequests' target=hoddashboardshow>View Mentor Requests</a>");
		out.println("<br><br><a href='ShowRegisteredMentor' target=hoddashboardshow>View Registered Mentor</a>");
		out.println("</html>");
	}

	

}

package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MentorDashBoard
 */
@WebServlet("/MentorDashBoard")
public class MentorDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorDashBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<h5>welcome to mentor dashboard</h5>");
		out.println("<br><br><a href='ShowStudentRequests' target=mentordashboardshow>View Student Requests</a>");
		out.println("<br><br><a href='ShowRegisteredStudent' target=mentordashboardshow>View Registered Students</a>");
		out.println("</html>");
	}

	
}

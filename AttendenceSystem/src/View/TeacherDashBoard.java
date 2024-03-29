package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TeacherDashBoard
 */
@WebServlet("/TeacherDashBoard")
public class TeacherDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherDashBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession(false);
		 if(session!=null && session.getAttribute("access").equals("teacher"))
		 {
		 out.println("<html>");
		 out.println("<h3>Teacher DashBoard</h3>");
		 out.println("<a href='TeacherDashShow' target=teacherdashboardshow >Homepage</a><br><br>");
		 out.println("<a href='GiveStudentAttendance' target=teacherdashboardshow >GiveAttendance</a><br><br>");
		
		 out.println("</html>");
		 }
		 else
			 response.sendRedirect("TeacherLogin");
	}

	

}

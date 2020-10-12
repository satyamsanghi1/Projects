
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
 * Servlet implementation class TeacherHomepage
 */
@WebServlet("/TeacherHomepage")
public class TeacherHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		
		// get collegeid and branch and subject of teacher from the teacher login
        // teacher will give the attendence to the student
		// teacher can see the attendence of the student
		HttpSession session =request.getSession(false);
		
		if(session!=null && session.getAttribute("access").equals("teacher"))
		{
		out.println("<html>");
		 out.println("<a href='TeacherLogout'>LogOut</a><br><br>");
		out.println("<iframe src='TeacherDashBoard' align='left' height='100% '></iframe>");
		out.println("<iframe src='TeacherDashShow' align='right'  height='100%' width='73%' name=teacherdashboardshow></iframe>");
		
	
		out.println("</html>");
		}
	else
		{
			response.sendRedirect("TeacherLogin");
		}
	}



}

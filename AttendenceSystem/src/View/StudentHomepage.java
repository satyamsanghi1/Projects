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
 * Servlet implementation class StudentHomepage
 */
@WebServlet("/StudentHomepage")
public class StudentHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("student").equals("student"))
		{
			out.print("welcome "+session.getAttribute("studentname"));

		out.println("<html>");
		 out.println("<a href='StudentLogout'>LogOut</a><br><br>");
		out.println("<iframe src='StudentDashBoard' align='left' height='100% '></iframe>");
		out.println("<iframe src='StudentDashShow' align='right'  height='100%' width='73%' name=studentdashboardshow></iframe>");
		
	
		out.println("</html>");
		}
	else
		{
			response.sendRedirect("StudentLogin");
		}
	}

	

}

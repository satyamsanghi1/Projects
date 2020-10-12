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
 * Servlet implementation class MentorHomepage
 */
@WebServlet("/MentorHomepage")
public class MentorHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//out.print("welcome to mentor homepage");
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("mentor").equals("mentor"))
		{
			out.println("<html>");
			out.println("<h4>welcome "+session.getAttribute("mentorname")+"</h4>");
		 out.println("<a href='MentorLogout'>LogOut</a><br><br>");
		out.println("<iframe src='MentorDashBoard' align='left' height='100% '></iframe>");
		out.println("<iframe src='MentorDashShow' align='right'  height='100%' width='73%' name=mentordashboardshow></iframe>");
		
	
		out.println("</html>");
		}
	else
		{
			response.sendRedirect("MentorLogin");
		}
	}

	

}

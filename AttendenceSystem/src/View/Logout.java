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
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session =request.getSession(false);
		
		// having error in redirecting to mentor login page after logout
		
		/*if(session!=null && session.getAttribute("access").equals("teacher"))
		{
			session.invalidate();
		response.sendRedirect("TeacherLogin");
		}
		else if(session!=null && session.getAttribute("access").equals("student"))
		{
			session.invalidate();
		response.sendRedirect("StudentLogin");
		}*/
		if(session!=null && session.getAttribute("mentor").equals("mentor"))
		{
			out.print("logout page");
			session.invalidate();
		response.sendRedirect("MentorLogin");
		}
	 
	}

	

}

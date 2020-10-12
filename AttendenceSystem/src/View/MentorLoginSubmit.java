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

import Controller.HODController;
import Controller.MentorController;

/**
 * Servlet implementation class MentorLoginSubmit
 */
@WebServlet("/MentorLoginSubmit")
public class MentorLoginSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorLoginSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    PrintWriter out=response.getWriter();
        String enrollmentno = request.getParameter("enrollmentno");
		String password = request.getParameter("password");
		ResultSet rs = MentorController.loginCheck(enrollmentno, password);
		
		try {

			if (rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("mentor","mentor");
				session.setAttribute("mentorname",rs.getString(2));
				session.setAttribute("mentordepartment",rs.getString(3));
				session.setAttribute("mentorenrollmentno",rs.getString(1));
				session.setAttribute("mentorbatch",rs.getString(4));
				session.setAttribute("mentorcollege",rs.getString(8));
			response.sendRedirect("MentorHomepage");
			} else {
				out.println("Login failed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		out.flush();
		
	}

	

}

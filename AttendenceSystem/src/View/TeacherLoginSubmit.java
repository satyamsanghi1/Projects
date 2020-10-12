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
import Controller.TeacherController;

/**
 * Servlet implementation class TeacherLoginSubmit
 */
@WebServlet("/TeacherLoginSubmit")
public class TeacherLoginSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLoginSubmit() {
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
		ResultSet rs = TeacherController.loginCheck(enrollmentno, password);
		
		try {

			if (rs.next()) {
				HttpSession session=request.getSession();
				session.setAttribute("access","teacher");
				session.setAttribute("teacherenrollmentno",rs.getString(1));
				session.setAttribute("teacherbranch",rs.getString(3));
				session.setAttribute("teachersubject",rs.getString(4));
				session.setAttribute("teachercollege",rs.getString(5));
			response.sendRedirect("TeacherHomepage");
			} else {
				out.println("Login failed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		out.flush();
	}



}

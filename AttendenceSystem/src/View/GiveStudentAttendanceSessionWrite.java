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
 * Servlet implementation class GiveStudentAttendanceSessionWrite
 */
@WebServlet("/GiveStudentAttendanceSessionWrite")
public class GiveStudentAttendanceSessionWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveStudentAttendanceSessionWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		if(session!=null && session.getAttribute("access").equals("teacher"))
		{
		String date=request.getParameter("date");
		String batch=request.getParameter("batch");
		String semester=request.getParameter("semester");
		String section=request.getParameter("section");
		session.setAttribute("date",date);
		session.setAttribute("batch",batch);
		session.setAttribute("semester",semester);
		session.setAttribute("section",section);
		response.sendRedirect("GiveStudentAttendanceSubmit");
		}
		else
			response.sendRedirect("TeacherLogin");
	}


	}



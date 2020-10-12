package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.StudentController;
import Controller.TeacherController;

/**
 * Servlet implementation class HandleStudentAttendance
 */
@WebServlet("/HandleStudentAttendance")
public class HandleStudentAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleStudentAttendance() {
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
	String rollno=request.getParameter("rollno");
	String attendancestatus=request.getParameter("attendancestatus");
	session.setAttribute(rollno,attendancestatus);
	String date=request.getParameter("date");
	String collegeid=request.getParameter("collegeid");
	String teacherenrollmentno=request.getParameter("teacherenrollmentno");
	
	
	   boolean rs=TeacherController.assignAttendance(rollno, teacherenrollmentno,attendancestatus, collegeid, date);
	response.sendRedirect("GiveStudentAttendanceSubmit");
		}
		else
			response.sendRedirect("TeacherLogin");
	}

	

}

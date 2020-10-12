package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.DBHelper;
import Controller.StudentController;
import Controller.TeacherController;

/**
 * Servlet implementation class GiveStudentAttendanceSubmit
 */
@WebServlet("/GiveStudentAttendanceSubmit")
public class GiveStudentAttendanceSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveStudentAttendanceSubmit() {
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
			String attend=request.getParameter("attend");
		String department=session.getAttribute("teacherbranch").toString();
		String collegeid=session.getAttribute("teachercollege").toString();
		String teacherenrollmentno=session.getAttribute("teacherenrollmentno").toString();
		
		out.println(department);
		out.println(collegeid);
		out.println(teacherenrollmentno);
		out.println(session.getAttribute("date").toString());
		out.println(session.getAttribute("batch").toString());
        out.println(session.getAttribute("semester").toString());
        out.println( session.getAttribute("section").toString());
        ResultSet res;
		ResultSet rs=TeacherController.showStudentForAttendance(collegeid, department,session.getAttribute("batch").toString(), session.getAttribute("semester").toString(), session.getAttribute("section").toString());
		
		//ResultSet res=StudentController.showStudentAttendance(collegeid, teacherenrollmentno,"present",session.getAttribute("date").toString());

		//out.println(DBHelper.JSONEngine(rs));
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>Names</td>");
		out.println("<td >Attendance</td><td></td>");
		out.println("<td>Attendance Status</td>");
		out.println("</tr>");
		try {
			while(rs.next())
			{
				res=StudentController.showStudentAttendance(collegeid, teacherenrollmentno,rs.getString(1), session.getAttribute("date").toString());
				     
				out.println("<tr>");
				out.println("<td>"+rs.getString(2)+"</td>");

				out.println("<td><a href='HandleStudentAttendance?rollno="+rs.getString(1)+"&attendancestatus=present&teacherenrollmentno="+teacherenrollmentno+"&date="+session.getAttribute("date").toString()+"&collegeid="+collegeid+"'>Present</a></td>");
				out.println("<td><a href='HandleStudentAttendance?rollno="+rs.getString(1)+"&attendancestatus=absent&teacherenrollmentno="+teacherenrollmentno+"&date="+session.getAttribute("date").toString()+"&collegeid="+collegeid+"'>Absent</a></td>");
	            out.println("<td>"+session.getAttribute(rs.getString(1))+"</td>");
				out.println("</tr>");
			}
		} catch (Exception e) {
		    System.out.print(e);
		}

		out.println("</table>");
        

		out.println("</html>");
		}
		else
			response.sendRedirect("TeacherLogin");
	}



}

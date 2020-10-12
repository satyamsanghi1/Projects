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

import Controller.DBHelper;
import Controller.StudentController;

/**
 * Servlet implementation class ShowStudentAttendance
 */
@WebServlet("/ShowStudentAttendance")
public class ShowStudentAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentAttendance() {
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
		
		//out.print(session.getAttribute("studentrollno").toString());
		ResultSet rs=StudentController.showStudentAttendance1(session.getAttribute("studentrollno").toString());
		//out.println(DBHelper.JSONEngine(rs));
		out.println("<html>");
		out.println("<h5>welcome to student attendance page</h5>");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<td>teacherName</td>");
		out.println("<td>Subject</td>");
		out.println("<td>Date</td>");
		out.println("<td>attendance Status</td>");
		out.println("</tr>");
		try {
		while(rs.next())
		{
			out.println("<tr>");
			out.println("<td>"+rs.getString("name")+"</td>");
			out.println("<td>"+rs.getString("subject")+"</td>");
			out.println("<td>"+rs.getString("date")+"</td>");
			out.println("<td>"+rs.getString("attendance")+"</td>");
			out.println("</tr>");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
          out.println("</table>");
          out.println("</html>");
	
	}
	
	else
		response.sendRedirect("StudentLogin");
	}		
	

}

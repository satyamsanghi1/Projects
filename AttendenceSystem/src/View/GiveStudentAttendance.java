package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GiveStudentAttendance
 */
@WebServlet("/GiveStudentAttendance")
public class GiveStudentAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveStudentAttendance() {
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
		//we  might use hidden form field to send branch and collegeid
		out.println("<h3>welcome to give attendance page</h3>");
		 out.println("<script src='Jquery/jquery-3.3.1.js'></script>");
		out.println("<script src='Jquery/GetBatch.js'></script>");
     	out.println("<script src='Jquery/GetSection.js'></script>");
     	out.println("<script src='Jquery/GetSemester.js'></script>");
		out.println("<html>");
		out.println("<table>");
		out.println("<form action=GiveStudentAttendanceSessionWrite>");
		out.println("<caption><h5>Enter Student Details</h5></caption>");
		out.println("<tr>");
		out.println("<td>Batch</td>");
		out.println("<td><select id=batch name= batch></select></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Section</td>");
		out.println("<td><select id=section name=section></select></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Semester</td>");
		out.println("<td><select id=semester name=semester></select></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Date</td>");
		out.println("<td><input type='text'  name=date></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<input type=submit></form></html>");
		
	}

	

}

package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentRegistrationView
 */
@WebServlet("/StudentRegistrationView")
public class StudentRegistrationView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		   out.println("<script src='Jquery/jquery-3.3.1.js'></script>");
	     	out.println("<script src='Jquery/GetCollegeNames.js'></script>");
	     	out.println("<script src='Jquery/GetBranch.js'></script>");
	     	out.println("<script src='Jquery/GetBatch.js'></script>");
	     	out.println("<script src='Jquery/GetSection.js'></script>");
	     	out.println("<script src='Jquery/GetSemester.js'></script>");
		   out.println("<html>");
	     	out.println("<form action=StudentRegistrationSubmit>");
	     	out.println("<table width=70% >");
	     	out.println("<caption>Student Registration</caption>");
	     	out.println("<tr>");
	     	out.println("<td>roll number</td>");
	     	out.println("<td><input type='text' name=rollno></td>");
	     	out.println("</tr>");
	     	out.println("<tr>");
	     	out.println("<td>Name</td>");
	     	out.println("<td><input type='text' name=name></td>");
	     	out.println("</tr>");
	     	out.println("<tr>");
	     	out.println("<td>Department</td>");
	     	out.println("<td><select id=department name=department></select></td>");
	     	out.println("</tr>");
	    	out.println("<tr>");
	     	out.println("<td>Batch</td>");
	     	out.println("<td><select id=batch name=batch></select></td>");
	     	out.println("</tr>");
	     	out.println("<tr>");
	     	out.println("<td>Semester</td>");
	     	out.println("<td><select id=semester name=semester></select></td>");
	     	out.println("</tr>");
	     	out.println("<tr>");
	     	out.println("<td>college</td>");
	     	out.println("<td><select id=collegeid name=collegeid></select></td>");
	     	out.println("</tr>");
	     	out.println("<tr>");
	     	out.println("<td>Email</td>");
	     	out.println("<td><input type='text' name=email></td>");
	     	out.println("</tr>");
	     	out.println("<tr>");
	     	out.println("<td>Phoneno</td>");
	     	out.println("<td><input type='text' name=phoneno></td>");
	     	out.println("</tr>");
	     	out.println("<tr>");
	     	out.println("<td>Section</td>");
	     	out.println("<td><select id=section name=section></select></td>");
	     	out.println("</tr>");
	     	out.println("<tr>");
	     	out.println("<td>Password</td>");
	     	out.println("<td><input type='text' name=password></td>");
	     	out.println("</tr>");
	     	out.println("</table><br><br>");
	     	out.println("<input type=submit ><input type=reset>");
	     	out.println("</form>");
	     	out.println("</html>");
	     	out.flush();
	}



}

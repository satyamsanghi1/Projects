package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HODRegistrationView
 */
@WebServlet("/HODRegistrationView")
public class HODRegistrationView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HODRegistrationView() {
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

	out.println("<html>");
	out.println("<form action=HODRegistrationSubmit>");
	out.println("<table width=70% >");
	out.println("<caption>HOD Registration</caption>");
	out.println("<tr>");
	out.println("<td>Enollment number</td>");
	out.println("<td><input type='text' name=rollno></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Name</td>");
	out.println("<td><input type='text' name=name></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>College</td>");
	out.println("<td><select id=collegeid name=collegeid ></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Department</td>");
	out.println("<td><select id=department name=department></select></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td>Username</td>");
	out.println("<td><input type='text' name=username></td>");
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

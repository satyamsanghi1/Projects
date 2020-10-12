package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CollegeRegistrationView
 */
@WebServlet("/CollegeRegistrationView")
public class CollegeRegistrationView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeRegistrationView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("<script src='Jquery/jquery-3.3.1.js'></script>");
		out.println("<script src='Jquery/CountryStateCity.js'></script>");
	//	out.println("<script src='Jquery/GetCollegeNames.js'></script>");

		out.println("<html>");
		out.println("<form action=CollegeREgistrationSubmit>");
		out.println("<table width=70% >");
		out.println("<caption>College Registration</caption>");
		out.println("<tr>");
		out.println("<td>CollegeName</td>");
		out.println("<td><input type='text' name=collegename></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>CollegeID</td>");
		out.println("<td><input type='text' name=collegeid></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Email</td>");
		out.println("<td><input type='text'  name=email></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>userID</td>");
		out.println("<td><input type='text'  name=userid></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Password</td>");
		out.println("<td><input type='text'  name=password></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>ConfirmPassword</td>");
		out.println("<td><input type='text'  name=cpassword></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td><select id='country' name=country></select></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td><input type='text'  name=state></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td><input type='text'  name=city></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Address</td>");
		out.println("<td><Textarea  name=address></TEXTAREA></td>");
		out.println("</tr>");
		
		out.println("</table><br><br>");
		out.println("<input type=submit ><input type=reset>");
		out.println("</form>");
		out.println("</html>");
		out.flush();
		
	}

	

}

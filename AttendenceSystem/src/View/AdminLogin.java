package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<table>");
		out.println("<form action=AdminLoginSubmit>");
		out.println("<caption>Admin Login</caption");
		out.println("<tr>");
		out.println("<td>User Name:</td> ");
		out.println("<td><input type='text' name=username></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Password :</td>");
		out.println("<td><input type='text' name=password></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<br><br>");
		out.println("<input type=submit><input type=reset> ");
		out.println("</form></html>");
		out.flush();
		
		
	}

	
	}


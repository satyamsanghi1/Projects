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

import Controller.AdminController;

/**
 * Servlet implementation class AdminHomepage
 */
@WebServlet("/AdminHomepage")
public class AdminHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs1 = AdminController.showCollegeRequests();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("admin").equals("admin"))
		{
		out.println("<iframe src='CollegeRegistered' align='right' height='450px' width='400px'></iframe");
		
		out.println("<html>");
		out.println("<a href='AdminLogout'>LogOut</a><br>");
		out.println("Welcome "+session.getAttribute("adminname").toString());
		out.println("<META HTTP-EQUIV='refresh' CONTENT='10'>");
		out.println("<h4>CollegeRegistrationRequests :</h4><br>");
		
		
		out.println("<table border='1'>");
		 out.println("<tr>");
			out.println("<td><h5>CollegeNames</h5></td>");
			out.println("</tr>");
		try {
		while (rs1.next()) {
			
			out.println("<tr>");
			out.println("<td>"+rs1.getString("name")+"</td>");
			out.println("<td><a href ='HandleCollegeRequests?acceptcollegeid="+rs1.getString("collegeid")+"&page=admin'>accept</a></td>");
			
	        out.println("</tr>");
	       
		}
		 out.println("</table></html>");
		
	}
catch(Exception e)
		{
	System.out.println(e);
		}
	
		}
		else
			response.sendRedirect("AdminLogin");
}
}

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
import Controller.CollegeController;

/**
 * Servlet implementation class CollegeRegistered
 */
@WebServlet("/CollegeRegistered")
public class CollegeRegistered extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeRegistered() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                       PrintWriter out=response.getWriter();
                       ResultSet res=AdminController.showRegisteredCollege();
                       HttpSession session=request.getSession(false);
               		if(session!=null && session.getAttribute("admin").equals("admin"))
               		{
                     try
                     {
                 out.println("<html>");
                 out.println("<META HTTP-EQUIV='refresh' CONTENT='10'>");
                 out.println("<h4>CollegeRegistered</h4>");
                 out.println("<table>");
                 out.println("<tr>");
      			out.println("<td><h5>CollegeNames</h5></td>");
      			out.println("</tr>");
                 while (res.next()) {
         			
         			out.println("<tr>");
         			
         			out.println("<td>"+res.getString("name")+"</td>");
         			out.println("<td><a href ='HandleCollegeRequests?removecollegeid="+res.getString("collegeid")+"&page=CollegeRegistered'>CancelApproval</a></td>");
         			
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

	
	



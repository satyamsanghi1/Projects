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

import Controller.MentorController;

/**
 * Servlet implementation class ShowRegisteredStudent
 */
@WebServlet("/ShowRegisteredStudent")
public class ShowRegisteredStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRegisteredStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        PrintWriter out=response.getWriter();
	       
	        HttpSession session=request.getSession(false);
			if(session!=null && session.getAttribute("mentor").equals("mentor"))
			{
			ResultSet rs=MentorController.showRegisteredStudent(session.getAttribute("mentorcollege").toString(),session.getAttribute("mentordepartment").toString(),session.getAttribute("mentorbatch").toString());
			//out.println(DBHelper.JSONEngine(rs));
			
			out.println("<html>");
			 out.println("welcome to student registered page");
	        out.println("<table>");
	        out.println("<tr>");
	        out.println("<td>Student Name</td>");
	        out.println("<td>Roll No</td>");
	        out.println("<td>Approval</td>");
	      
	        out.println("</tr>");
	        try
	        {
	        while(rs.next())
	        {
	        	 out.println("<tr>");
			 out.println("<td>"+rs.getString("name")+"</td>");
			 out.println("<td>"+rs.getString("rollno")+"</td>");
			 out.println("<td><a href ='HandleStudentRequests?DeclineStudentApproval="+rs.getString("rollno")+"&page=ShowRegisteredStudent'>DeclineApproval</a></td>");
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
				response.sendRedirect("MentorLogin");
			
	}

	

}

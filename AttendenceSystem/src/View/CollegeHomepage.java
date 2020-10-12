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

import Controller.CollegeController;

/**
 * Servlet implementation class CollegeHomepage
 */
@WebServlet("/CollegeHomepage")
public class CollegeHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	              PrintWriter out=response.getWriter();
	              HttpSession session=request.getSession(false);
	              //get the collegeid of hod when he logins with the help of session
	            
	              if(session!=null && session.getAttribute("college").equals("college"))
	      		{
	            	  ResultSet rs=CollegeController.showHodRequests(session.getAttribute("collegeid").toString());
		              ResultSet res=CollegeController.showRegisteredHod(session.getAttribute("collegeid").toString());
	              out.println("<html>");
	              out.println("<h4>Welcome to "+session.getAttribute("collegename")+" Homepage</h4>");
	              out.println("<a href='CollegeLogout'>LogOut</a><br>");
	              out.println("<table border='1'>");
	              out.println("<caption>HOD Requests</caption>");
	              out.println("<tr>");
	              out.println("<td>Hod Name</td>");
	              out.println("<td>Hod Department</td>");
	              out.println("</tr>");
	              try {
					while(rs.next())
					{
						 out.println("<tr>");
						 out.println("<td>"+rs.getString("name")+"</td>");
						 out.println("<td>"+rs.getString("branchname")+"</td>");
						 out.println("<td><a href ='HandleHodRequests?AcceptHodRequest="+rs.getString("enrollmentno")+"'>accept</a></td>");
						 out.println("<td><a href ='HandleHodRequests?CancelHodRequests="+rs.getString("enrollmentno")+"'>decline</a></td>");
						 out.println("</tr>");
					}
					 out.println("</table><br><br>");
					 
				} catch (SQLException e) {
					System.out.println(e);
				}
	              out.println("<table border='1'>");
					 out.println("<caption>HOD Registered</caption>");
					 out.println("<tr>");
					 out.println("<td>HOD Name</td>");
					 out.println("<td>HOD Department</td>");
                     out.println("</tr>");
                     try {
     					while(res.next())
     					{
     						 out.println("<tr>");
     						 out.println("<td>"+res.getString("name")+"</td>");
     						 out.println("<td>"+res.getString("branchname")+"</td>");
     						 out.println("<td><a href ='HandleHodRequests?DeclineHodApproval="+res.getString("enrollmentno")+"'>declineApproval</a></td>");
     						
     						 out.println("</tr>");
     					}
     					 out.println("</table></html>");
     					 
     				} catch (SQLException e) {
     					System.out.println(e);
     				}
	      		}
	              else
	            	  response.sendRedirect("CollegeLogin");
	            
	}

	

}

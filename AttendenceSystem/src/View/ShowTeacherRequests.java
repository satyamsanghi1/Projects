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

import Controller.DBHelper;
import Controller.HODController;

/**
 * Servlet implementation class ShowTeacherRequests
 */
@WebServlet("/ShowTeacherRequests")
public class ShowTeacherRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTeacherRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(false);
		ResultSet rs=HODController.showTeacherRequests(session.getAttribute("hodcollegeid").toString(),session.getAttribute("hoddepartment").toString());
	

		//out.println(DBHelper.JSONEngine(rs));
		try {
			   out.println("<html>");
		       out.println("<table border=1>");
				 out.println("<caption>Teacher Requests</caption>");
		       out.println("<tr>");
		       out.println("<td>Teacher Name</td>");
		       out.println("<td>Teacher Department</td>");
		       out.println("<td>Teacher EnrollmentNo</td>");
		       out.println("<td colspan='2'>Approval</td>");
		       out.println("</tr>");
		   while(rs.next())
		   {  
		         out.println("<tr>");
			     out.println("<td>"+rs.getString("name")+"</td>");
			     out.println("<td>"+rs.getString("branchname")+"</td>");
			     out.println("<td>"+rs.getString("enrollmentno")+"</td>");
				 out.println("<td><a href ='HandleTeacherRequests?page=ShowTeacherRequests&AcceptTeacherRequest="+rs.getString("enrollmentno")+"'>accept</a></td>");
				 out.println("<td><a href ='HandleTeacherRequests?page=ShowTeacherRequests&CancelTeacherRequests="+rs.getString("enrollmentno")+"'>decline</a></td>");
				 out.println("</tr>");
		       
		   }
		        out.println("</table>");
		        out.println("</html>");
		   // out.println("hello");
		    //
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//out.println("hello");
		
		
	}

	

}

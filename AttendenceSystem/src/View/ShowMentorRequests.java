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

import Controller.DBHelper;
import Controller.HODController;

/**
 * Servlet implementation class ShowMentorRequests
 */
@WebServlet("/ShowMentorRequests")
public class ShowMentorRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMentorRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		ResultSet rs=HODController.showMentorRequests(session.getAttribute("hodcollegeid").toString(),session.getAttribute("hoddepartment").toString());
		//out.println(DBHelper.JSONEngine(rs));
		
		 out.println("<html>");
         out.println("<table border='1'>");
         out.println("<caption>Mentor Requests</caption>");
         out.println("<tr>");
         out.println("<td>Mentor Name</td>");
         out.println("<td>Mentor Batch</td>");
         out.println("<td>Mentor EnrolllmentNo</td>");
         out.println("<td colspan='2'>Approval</td>");
         out.println("</tr>");
         try {
			while(rs.next())
			{
				 out.println("<tr>");
				 out.println("<td>"+rs.getString("name")+"</td>");
				 out.println("<td>"+rs.getString(4)+"</td>");
				 out.println("<td>"+rs.getString("enrollmentno")+"</td>");
				 out.println("<td><a href ='HandleMentorRequests?page=ShowMentorRequests&AcceptMentorRequest="+rs.getString("enrollmentno")+"'>accept</a></td>");
				 out.println("<td><a href ='HandleMentorRequests?page=ShowMentorRequests&CancelMentorRequests="+rs.getString("enrollmentno")+"'>decline</a></td>");
				 out.println("</tr>");
			}
			 out.println("</table><br><br>");
			 
		} catch (Exception e) {
			System.out.println(e);
		}
         out.println("</html>");
	}

	

}

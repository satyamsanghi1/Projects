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
 * Servlet implementation class ShowRegisteredTeacher
 */
@WebServlet("/ShowRegisteredTeacher")
public class ShowRegisteredTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRegisteredTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession(false);
		ResultSet res=HODController.showRegisteredTeacher(session.getAttribute("hodcollegeid").toString(),session.getAttribute("hoddepartment").toString());
		//out.println(DBHelper.JSONEngine(res));
		 out.println("<table border='1'>");
		 out.println("<caption>Teacher Registered</caption>");
		 out.println("<tr>");
		 out.println("<td>Teacher Name</td>");
		 out.println("<td>Teacher Department</td>");
		 out.println("<td>Teacher EnrollmentNo</td>");
		 out.println("<td></td>");
         out.println("</tr>");
        try {
			while(res.next())
			{
				 out.println("<tr>");
				 out.println("<td>"+res.getString("name")+"</td>");
				 out.println("<td>"+res.getString("branchname")+"</td>");
				 out.println("<td>"+res.getString("enrollmentno")+"</td>");
				 out.println("<td><a href ='HandleTeacherRequests?DeclineTeacherApproval="+res.getString("enrollmentno")+"'>declineApproval</a></td>");
				
				 out.println("</tr>");
			}
			 out.println("</table></html>");
			 
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

}

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
 * Servlet implementation class ShowRegisteredMentor
 */
@WebServlet("/ShowRegisteredMentor")
public class ShowRegisteredMentor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRegisteredMentor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		ResultSet rs1=HODController.showRegisteredMentor(session.getAttribute("hodcollegeid").toString(),session.getAttribute("hoddepartment").toString());
		//out.println(DBHelper.JSONEngine(rs1));
		 out.println("<table border='1'>");
		 out.println("<caption>Mentor Registered</caption>");
		 out.println("<tr>");
		 out.println("<td>Mentor Name</td>");
		 out.println("<td>Mentor Department</td>");
		 out.println("<td>Mentor EnrollmentNo</td>");
		 out.println("<td>Approval</td>");
		 
         out.println("</tr>");
        try {
			while(rs1.next())
			{
				 out.println("<tr>");
				 out.println("<td>"+rs1.getString("name")+"</td>");
				 out.println("<td>"+rs1.getString("branchname")+"</td>");
				 out.println("<td>"+rs1.getString("enrollmentno")+"</td>");
				 out.println("<td><a href ='HandleMentorRequests?page=ShowRegisteredMentor&DeclineMentorApproval="+rs1.getString("enrollmentno")+"'>declineApproval</a></td>");
				
				 out.println("</tr>");
			}
			 out.println("</table></html>");
			 
		} catch (Exception e) {
			System.out.println(e);
		}
	}


}

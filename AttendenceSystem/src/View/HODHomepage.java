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

import Controller.HODController;

/**
 * Servlet implementation class HODHomepage
 */
@WebServlet("/HODHomepage")
public class HODHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HODHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//out.println("welcome to hod homepage");
		//when hod will login it will give collegeid and department to this page through session
		//so that only those teacher details will be shown whose branch and college of hod and teacher are same
		
		  
		  
		 HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("HOD").equals("HOD"))
		{
			out.println("<html>");
			out.println("<h4>welcome "+session.getAttribute("hodname")+"</h4>");
		 out.println("<a href='HODLogout'>LogOut</a><br><br>");
		out.println("<iframe src='HODDashBoard' align='left' height='100% '></iframe>");
		out.println("<iframe src='HODDashShow' align='right'  height='100%' width='73%' name=hoddashboardshow></iframe>");
		
	
		out.println("</html>");
		}
	else
		{
			response.sendRedirect("HODLogin");
		} 
		
		
		/*ResultSet rs=HODController.showTeacherRequests("1","1");
		ResultSet res=HODController.showRegisteredTeacher("1","1");
		ResultSet rs1=HODController.showMentorRequests("1","1");
		 out.println("<html>");
         out.println("<table border='1'>");
         out.println("<caption>Teacher Requests</caption>");
         out.println("<tr>");
         out.println("<td>Teacher Name</td>");
         out.println("<td>Teacher Department</td>");
         out.println("</tr>");
         try {
			while(rs.next())
			{
				 out.println("<tr>");
				 out.println("<td>"+rs.getString("name")+"</td>");
				 out.println("<td>"+rs.getString("branchname")+"</td>");
				 out.println("<td><a href ='HandleTeacherRequests?AcceptTeacherRequest="+rs.getString("enrollmentno")+"'>accept</a></td>");
				 out.println("<td><a href ='HandleTeacherRequests?CancelTeacherRequests="+rs.getString("enrollmentno")+"'>decline</a></td>");
				 out.println("</tr>");
			}
			 out.println("</table><br><br>");
			 
		} catch (SQLException e) {
			System.out.println(e);
		}
         out.println("<table border='1'>");
			 out.println("<caption>Teacher Registered</caption>");
			 out.println("<tr>");
			 out.println("<td>Teacher Name</td>");
			 out.println("<td>Teacher Department</td>");
            out.println("</tr>");
            try {
				while(res.next())
				{
					 out.println("<tr>");
					 out.println("<td>"+res.getString("name")+"</td>");
					 out.println("<td>"+res.getString("branchname")+"</td>");
					 out.println("<td><a href ='HandleTeacherRequests?DeclineTeacherApproval="+res.getString("enrollmentno")+"'>declineApproval</a></td>");
					
					 out.println("</tr>");
				}
				 out.println("</table></html>");
				 
			} catch (SQLException e) {
				System.out.println(e);
			}*/
				
		
	}

	

}

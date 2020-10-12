package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.HODController;
import Controller.MentorController;

/**
 * Servlet implementation class HandleStudentRequests
 */
@WebServlet("/HandleStudentRequests")
public class HandleStudentRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleStudentRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        PrintWriter out=response.getWriter();
	        String page=request.getParameter("page");
	        boolean a=false;
	        boolean b=false;
	        boolean c=false;
	        boolean d=false;
	        // these two values are called when mentor accepts and cancel the student request
	        String acceptstudentrequest=request.getParameter("AcceptStudentRequest");
	        String cancelstudentrequest=request.getParameter("CancelStudentRequest");
	        String declinestudentapproval=request.getParameter("DeclineStudentApproval");
	      //when mentor cancels the approval of student ,the record of that student is deleted from teacher student  
			
			 c=MentorController.cancelStudentApproval(declinestudentapproval);
			
			//when mentor accepts the teacher requests , the approval field of student table becomes true and the request is removed from mentor request table 
			
			 a=MentorController.acceptStudentApproval(acceptstudentrequest);
			 b=MentorController.removeStudentRequests(acceptstudentrequest);
			
			//when mentor cancels the student request the request is removed from mentor  request table 
			// the record is also deleted from the student table
			 d=MentorController.removeStudentRequests(cancelstudentrequest);
			 MentorController.cancelStudentApproval(cancelstudentrequest);
		           if(page.equals("ShowStudentRequests"))
		        	   response.sendRedirect("ShowStudentRequests");
		           else if(page.equals("ShowRegisteredStudent"))
                       response.sendRedirect("ShowRegisteredStudent");
	}

	

}

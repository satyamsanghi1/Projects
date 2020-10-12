package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.HODController;

/**
 * Servlet implementation class HandleMentorRequests
 */
@WebServlet("/HandleMentorRequests")
public class HandleMentorRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleMentorRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String page=request.getParameter("page");
		String AcceptMentorEnrollmentNo=request.getParameter("AcceptMentorRequest");
		String CancelMentorRequests=request.getParameter("CancelMentorRequests");
		String MentorEnrollmentNo=request.getParameter("DeclineMentorApproval");
		
		//when hod cancels the approval of teacher ,the record of that teacher is deleted from teacher table  
		
		boolean c=HODController.cancelMentorApproval(MentorEnrollmentNo);
		
		//when hod accepts the teacher requests , the approval field of teacher table becomes true and the request is removed from hod request table 
		
		boolean a=HODController.acceptMentorApproval(AcceptMentorEnrollmentNo);
		boolean b=HODController.removeMentorRequests(AcceptMentorEnrollmentNo);
		
		//when hod cancels the teacher request the request is removed from hod  request table 
		
		boolean d=HODController.removeMentorRequests(CancelMentorRequests);
		boolean e=HODController.cancelMentorApproval(CancelMentorRequests);
		response.sendRedirect("page");
	}

	

}

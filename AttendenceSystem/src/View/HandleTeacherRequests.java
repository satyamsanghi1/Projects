package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CollegeController;
import Controller.HODController;

/**
 * Servlet implementation class HandleTeacherRequests
 */
@WebServlet("/HandleTeacherRequests")
public class HandleTeacherRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleTeacherRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String page=request.getParameter("page");
		String AcceptTeacherEnrollmentNo=request.getParameter("AcceptTeacherRequest");
		String CancelTeacherRequests=request.getParameter("CancelTeacherRequests");
		String TeacherEnrollmentNo=request.getParameter("DeclineTeacherApproval");
		
		//when hod cancels the approval of teacher ,the record of that teacher is deleted from teacher table  
		
		boolean c=HODController.cancelTeacherApproval(TeacherEnrollmentNo);
		
		//when hod accepts the teacher requests , the approval field of teacher table becomes true and the request is removed from hod request table 
		
		boolean a=HODController.acceptTeacherApproval(AcceptTeacherEnrollmentNo);
		boolean b=HODController.removeTeacherRequests(AcceptTeacherEnrollmentNo);
		
		//when hod cancels the teacher request the request is removed from hod  request table 
		
		boolean d=HODController.removeTeacherRequests(CancelTeacherRequests);
		boolean e=HODController.cancelTeacherApproval(CancelTeacherRequests);
		response.sendRedirect("page");
		
	}



}

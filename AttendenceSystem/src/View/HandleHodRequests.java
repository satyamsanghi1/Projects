package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.CollegeController;

/**
 * Servlet implementation class HandleHodRequests
 */
@WebServlet("/HandleHodRequests")
public class HandleHodRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleHodRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		 if(session!=null && session.getAttribute("college").equals("college"))
   		{
		String AccepthodEnrollmentNo=request.getParameter("AcceptHodRequest");
		String CancelHodRequests=request.getParameter("CancelHodRequests");
		String HodEnrollmentNo=request.getParameter("DeclineHodApproval");
		
		//when college cancels the approval of hod, the record of hod with that enrollment no is deleted 
		
		boolean c=CollegeController.cancelApproval(HodEnrollmentNo);
		
		//when college accepts the hod requests , the approval field of hod table becomes true and the request is removed from college request table 
		
		boolean a=CollegeController.acceptApproval(AccepthodEnrollmentNo);
		boolean b=CollegeController.removeHodRequests(AccepthodEnrollmentNo);
		
		//when college cancels the hod request ,the request is removed from college request table 
		
		boolean d=CollegeController.removeHodRequests(CancelHodRequests);
	
		response.sendRedirect("CollegeHomepage");
   		}
		 else
			 response.sendRedirect("CollegeLogin");
			

	}

}

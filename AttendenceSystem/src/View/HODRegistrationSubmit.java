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
import Model.HOD;

/**
 * Servlet implementation class HODRegistrationSubmit
 */
@WebServlet("/HODRegistrationSubmit")
public class HODRegistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HODRegistrationSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            
		PrintWriter out=response.getWriter();
	               HOD H=new HOD();
	               H.setCollegeid(request.getParameter("collegeid"));
	               H.setEnrollmentno(request.getParameter("rollno"));
	               H.setDepartment(request.getParameter("department"));
	               H.setName(request.getParameter("name"));
	               H.setEmail(request.getParameter("email"));
	               H.setUsername(request.getParameter("username"));
	               H.setPassword(request.getParameter("password"));
	               H.setPhoneno(request.getParameter("phoneno"));
	              
	               boolean res= HODController.addNewRecord(H);
	       		if(res)
	       		{
	       			HODController.addNewHODRequest(H.getEnrollmentno());
	       			out.println("RecordSubmitted");
	       		}
	       		else
	       		{
	       			out.println("Record Not Submitted");
	       		}
	       		out.flush();
	}

	
}

package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.TeacherController;
import Model.Teacher;

/**
 * Servlet implementation class TeacherRegistrationSubmit
 */
@WebServlet("/TeacherRegistrationSubmit")
public class TeacherRegistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherRegistrationSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               PrintWriter out=response.getWriter();
               Teacher T=new Teacher();
               T.setEnrollmentno(request.getParameter("enrollmentno"));
               T.setCollegeid(request.getParameter("collegeid"));
               T.setDepartment(request.getParameter("department"));
               T.setEmail(request.getParameter("email"));
               T.setName(request.getParameter("name"));
               T.setSubject(request.getParameter("subject"));
               T.setPassword(request.getParameter("password"));
             boolean res=  TeacherController.addNewRecord(T);
               if(res)
               {
            	   //out.println(request.getParameter("collegeid"));
            	   TeacherController.addNewTeacherRequest(T.getEnrollmentno());
            	   out.println("RecordSubmitted");
            	   
               }
               else
               {
            	   out.println("NotSubmitted");
               }
	}

	

}

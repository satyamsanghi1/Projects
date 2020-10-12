package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.StudentController;
import Model.Student;

/**
 * Servlet implementation class StudentRegistrationSubmit
 */
@WebServlet("/StudentRegistrationSubmit")
public class StudentRegistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 PrintWriter out=response.getWriter();
	 Student S=new Student();
	 S.setBatch(request.getParameter("batch"));
	 S.setCollegeid(request.getParameter("collegeid"));
	 S.setDepartment(request.getParameter("department"));
	 S.setEmail(request.getParameter("email"));
	 S.setName(request.getParameter("name"));
	 S.setPassword(request.getParameter("password"));
	 S.setPhoneno(request.getParameter("phoneno"));
	 S.setRollno(request.getParameter("rollno"));
	 S.setSection(request.getParameter("section"));
	 S.setSemester(request.getParameter("semester"));
	boolean res=StudentController.addNewRecord(S);
	if(res)
	{
		StudentController.addNewStudentRequest(S.getRollno());
		out.print("Record Submitted");
	}
	else
	{
		out.println("Record not submitted");
	}
	}



}

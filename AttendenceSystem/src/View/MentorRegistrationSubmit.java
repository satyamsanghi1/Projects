package View;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.MentorController;
import Model.Mentor;

/**
 * Servlet implementation class MentorRegistrationSubmit
 */
@WebServlet("/MentorRegistrationSubmit")
public class MentorRegistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorRegistrationSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Mentor M=new Mentor();
		M.setBatch(request.getParameter("batch"));
		M.setCollegeid(request.getParameter("collegeid"));
		M.setDepartment(request.getParameter("department"));
		M.setEmail(request.getParameter("email"));
		M.setEnrollmentno(request.getParameter("enrollmentno"));
		M.setName(request.getParameter("name"));
		M.setPassword(request.getParameter("password"));
		boolean rs=MentorController.addNewRecord(M);
		//out.println(M.getBatch());
		if(rs)
		{
			 boolean res=MentorController.addNewMentorRequest(M.getEnrollmentno());
			 if(res)
			out.print("Record Submitted");
			 else
				 out.println("Record not submitted");
				 
		}
		else
		{
			out.println("Record not submitted");
		}
	}


	}



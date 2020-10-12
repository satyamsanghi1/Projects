package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CollegeController;
import Model.CollegeRegistration;

/**
 * Servlet implementation class CollegeREgistrationSubmit
 */
@WebServlet("/CollegeREgistrationSubmit")
public class CollegeREgistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeREgistrationSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	
		CollegeRegistration C=new CollegeRegistration();
		C.setUserid(request.getParameter("userid"));
		C.setCollegename(request.getParameter("collegename"));
		C.setCollegeid(request.getParameter("collegeid"));
		C.setAddress(request.getParameter("address"));
		C.setEmail(request.getParameter("email"));
		C.setCity(request.getParameter("city"));
		C.setState(request.getParameter("state"));
		C.setCountry(request.getParameter("country"));
		C.setPassword(request.getParameter("password"));
		boolean res=CollegeController.addNewRecord(C);
		
		if(res)
		{
			CollegeController.addNewCollegeRequest(C.getCollegeid());
			out.println("RecordSubmitted");
		}
		else
		{
			out.println("Record Not Submitted");
		}
		out.flush();
	}

	}



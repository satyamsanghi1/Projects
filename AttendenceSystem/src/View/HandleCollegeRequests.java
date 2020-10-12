package View;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.AdminController;
import Controller.CollegeController;

/**
 * Servlet implementation class HandleCollegeRequests
 */
@WebServlet("/HandleCollegeRequests")
public class HandleCollegeRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleCollegeRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("admin").equals("admin"))
		{
		String acceptcollegeid=request.getParameter("acceptcollegeid");
		String removecollegeid=request.getParameter("removecollegeid");
		String page=request.getParameter("page");
		boolean a=AdminController.cancelApproval(removecollegeid);
		boolean b=AdminController.acceptApproval(acceptcollegeid) ;
        boolean c= AdminController.removeCollegeRequests(acceptcollegeid);
		out.println(page);
		if(page.equals("CollegeRegistered"))
		{
			response.sendRedirect("CollegeRegistered");
		}
		else if(page.equals("admin"))
		{
			response.sendRedirect("AdminHomepage");
		}
		}
		else
			response.sendRedirect("AdminLogin");
		
		
		
	}

	
	}



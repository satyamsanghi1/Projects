package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.CollegeController;
import Controller.HODController;

/**
 * Servlet implementation class HODLoginSubmit
 */
@WebServlet("/HODLoginSubmit")
public class HODLoginSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HODLoginSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                   PrintWriter out=response.getWriter();
	                   String enrollmentno = request.getParameter("enrollmentno");
	       			String password = request.getParameter("password");
	       			ResultSet rs = HODController.loginCheck(enrollmentno, password);
	       			
	       			try {

	       				if (rs.next()) {
	       					HttpSession session=request.getSession();
	       					session.setAttribute("HOD","HOD");
	       					session.setAttribute("hoddepartment",rs.getString(3));
	       					session.setAttribute("hodcollegeid",rs.getString(9));
	       					session.setAttribute("hodname",rs.getString(2));
	       				response.sendRedirect("HODHomepage");
	       				} else {
	       					out.println("Login failed");
	       				}
	       			} catch (Exception e) {
	       				System.out.println(e);
	       			}
	       			out.flush();
	}



}

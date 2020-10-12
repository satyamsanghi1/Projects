package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Controller.CollegeController;
import Controller.DBHelper;

/**
 * Servlet implementation class GetAllCollegeJSON
 */
@WebServlet("/GetAllCollegeJSON")
public class GetAllCollegeJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCollegeJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         PrintWriter out=response.getWriter();
         ResultSet rs=CollegeController.getAllCollege();
         ArrayList<JSONObject>obj =DBHelper.JSONEngine(rs);
         out.println(obj);
         
         
	}

	

}
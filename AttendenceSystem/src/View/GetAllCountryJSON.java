package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Controller.CountryStateCityController;
import Controller.DBHelper;

/**
 * Servlet implementation class GetAllCountryJSON
 */
@WebServlet("/GetAllCountryJSON")
public class GetAllCountryJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCountryJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                       PrintWriter out=response.getWriter();
                       ResultSet rs=CountryStateCityController.getAllCountry();
                      ArrayList<JSONObject> obj=DBHelper.JSONEngine(rs);
                      /*try {
                    	  ArrayList<JSONObject>obj=new ArrayList<JSONObject>();
                    	  
                    	  ResultSetMetaData rsmt=rs.getMetaData();
                    	 while( rs.next()){
                    		 JSONObject ob=new JSONObject();
                           	  for(int i=1;i<=rsmt.getColumnCount();i++)
                           	  {
                           		  ob.put(rsmt.getColumnName(i).toUpperCase(),rs.getString(i));
                           		
                           		//out.println(rsmt.getColumnName(i)+" "+rs.getString(i));
                           	 
                           	  }
                           	  obj.add(ob);
                           	
                    	 }
                    	 out.println(obj);
					} catch (Exception e) {
						System.out.print(e);
					}*/
                    
out.println(obj);
	

	}
}

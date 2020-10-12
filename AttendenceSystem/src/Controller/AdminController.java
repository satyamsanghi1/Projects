package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class AdminController {

	public static ResultSet loginCheck(String username,String password)
	{
		try {
			Connection con=DBHelper.openConnection();
			String query="select * from admin where username='"+username+"' and password='"+password+"'";
	       ResultSet rs= DBHelper.executeQuery(con, query);
	       return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	public static ResultSet showCollegeRequests()
	{
		try
		{
		Connection con=DBHelper.openConnection();
		String query="select C.name ,A.collegeid from college_registration C,admin_requests A where C.collegeid=A.collegeid";
	//	String query="sel";
		ResultSet rs=DBHelper.executeQuery(con, query);
		return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	public static ResultSet showRegisteredCollege()
	{
		String query="select name,collegeid from college_registration where approval='true'";
		Connection con=DBHelper.openConnection();
		ResultSet res=DBHelper.executeQuery(con, query);
		return res;
		
	}
	public static boolean cancelApproval(String collegeid)
	{
		String query="update college_registration set approval='false' where collegeid='"+collegeid+"'";
		//String query1="delete from college_registration where collegeid='"+collegeid+"'";
		Connection con=DBHelper.openConnection();
		boolean res=DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else
			return false;
	}
	public static boolean acceptApproval(String collegeid)
	{
		String query="update college_registration set approval='true' where collegeid='"+collegeid+"'";
		Connection con=DBHelper.openConnection();
		boolean res=DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else
			return false;
	}
	public static boolean removeCollegeRequests(String collegeid)
	{
		Connection con=DBHelper.openConnection();
		String query ="delete from admin_requests where collegeid='"+collegeid+"'";
		boolean res =DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else 
			return
					false;
	}
}

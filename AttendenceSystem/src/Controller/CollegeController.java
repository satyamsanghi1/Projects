package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

import Model.CollegeRegistration;

public class CollegeController 
{
public static boolean addNewRecord(CollegeRegistration C)
{
	try
	{
	String query,query1;
	query="insert into college_registration(name,email,userid,password,address,country,state,city,collegeid,approval) values('"+C.getCollegename()+"','"+C.getEmail()+"','"+C.getUserid()+"','"+C.getPassword()+"','"+C.getAddress()+"','"+C.getCountry()+"','"+C.getState()+"','"+C.getCity()+"','"+C.getCollegeid()+"','false')";
  
	//fills the college table with new collegenames and the collegeid 
	query1="insert into college values('"+C.getCollegeid()+"','"+C.getCollegename()+"')";   
	Connection con= DBHelper.openConnection();
 
  boolean res= DBHelper.executeUpdate(con, query);
  boolean rs=DBHelper.executeUpdate(con, query1);

  return res;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
}
public static boolean addNewCollegeRequest(String collegeid)
{
	try
	{
   Connection con= DBHelper.openConnection();
   String query1="insert into admin_requests values('"+collegeid+"')";
  boolean res= DBHelper.executeUpdate(con, query1);
  return res;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return false;
	}
}
//for json 
public static ResultSet getAllCollege()
{
	try
	{
		Connection cn=DBHelper.openConnection();
		String query="select collegeid,name from college_registration";
		ResultSet rs=DBHelper.executeQuery(cn, query);
		return rs;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	
}
public static ResultSet getAllBranch()
{
	try
	{
		Connection cn=DBHelper.openConnection();
		String query="select branchid,branchname from branch";
		ResultSet rs=DBHelper.executeQuery(cn, query);
		return rs;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	
}
public static ResultSet getAllBatch()
{
	try
	{
		Connection cn=DBHelper.openConnection();
		String query="select batchid,batchname from batch_section_semester";
		ResultSet rs=DBHelper.executeQuery(cn, query);
		return rs;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	
}
public static ResultSet getAllSection()
{
	try
	{
		Connection cn=DBHelper.openConnection();
		String query="select sectionid,sectionname from batch_section_semester";
		ResultSet rs=DBHelper.executeQuery(cn, query);
		return rs;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	
}
public static ResultSet getAllSemester()
{
	try
	{
		Connection cn=DBHelper.openConnection();
		String query="select semesterid,semestername from batch_section_semester";
		ResultSet rs=DBHelper.executeQuery(cn, query);
		return rs;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	
}
//
public static ResultSet loginCheck(String userid,String password)
{
	try {
		Connection con=DBHelper.openConnection();
		String query="select * from college_registration where userid='"+userid+"' and password='"+password+"' and approval='true'";
       ResultSet rs= DBHelper.executeQuery(con, query);
       return rs;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
}
public static ResultSet showHodRequests(String collegeid)
{
	try
	{
	Connection con=DBHelper.openConnection();
	String query="select H.name,H.enrollmentno,B.branchname from hod_registration H,college_requests R,branch B where H.enrollmentno=R.HodEnrollmentNo and H.collegeid='"+collegeid+"' and B.branchid=H.department";
	ResultSet rs=DBHelper.executeQuery(con, query);
	return rs;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
}
public static ResultSet showRegisteredHod(String collegeid)
{
	String query="select name,enrollmentno,B.branchname from hod_registration,branch B where approval='true' and collegeid='"+collegeid+"' and B.branchid=department";
	Connection con=DBHelper.openConnection();
	ResultSet res=DBHelper.executeQuery(con, query);
	return res;
	
}
public static boolean cancelApproval(String HodEnrollmentNo)
{
	String query="delete from hod_registration where enrollmentno='"+HodEnrollmentNo+"'";
	Connection con=DBHelper.openConnection();
	boolean res=DBHelper.executeUpdate(con, query);
	if(res)
		return true;
	else
		return false;
}
public static boolean acceptApproval(String HodEnrollmentNo)
{
	String query="update hod_registration set approval='true' where enrollmentno='"+HodEnrollmentNo+"'";
	Connection con=DBHelper.openConnection();
	boolean res=DBHelper.executeUpdate(con, query);
	if(res)
		return true;
	else
		return false;
}
public static boolean removeHodRequests(String HodEnrollmentNo)
{
	Connection con=DBHelper.openConnection();
	String query ="delete from college_requests where HodEnrollmentNo='"+HodEnrollmentNo+"'";
	boolean res =DBHelper.executeUpdate(con, query);
	if(res)
		return true;
	else 
		return
				false;
}
}

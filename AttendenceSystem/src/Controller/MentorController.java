package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

import Model.HOD;
import Model.Mentor;

public class MentorController {
	public static boolean addNewRecord(Mentor M)
	{
		try
		{
		String query="insert into mentor values('"+M.getEnrollmentno()+"','"+M.getName()+"','"+M.getDepartment()+"','"+M.getBatch()+"','"+M.getEmail()+"','"+M.getPassword()+"','false','"+M.getCollegeid()+"')";
	   Connection con= DBHelper.openConnection();
	  boolean res= DBHelper.executeUpdate(con, query);
	  return res;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public static boolean addNewMentorRequest(String MentorEnrollmentno)
	{
		try
		{
	   Connection con= DBHelper.openConnection();
	   String query1="insert into hod_requests(teacherenrollmentno,mentorenrollmentno) values('null','"+MentorEnrollmentno+"')";
	  
	 boolean res= DBHelper.executeUpdate(con, query1);
	  return res;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public static ResultSet loginCheck(String enrollmentno,String password)
	{
		try {
			Connection con=DBHelper.openConnection();
			String query="select * from mentor where enrollmentno='"+enrollmentno+"' and password='"+password+"' and approval='true'";
	       ResultSet rs= DBHelper.executeQuery(con, query);
	       return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	public static ResultSet showStudentRequests(String collegeid,String department,String batch)
	{
		try {
			Connection con=DBHelper.openConnection();
			String query="select S.name,S.rollno from student S,mentor_requests M where M.studentrollno=S.rollno and S.collegeid='"+collegeid+"' and S.department='"+department+"' and S.batch='"+batch+"'";
	       ResultSet rs= DBHelper.executeQuery(con, query);
	       return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	public static ResultSet showRegisteredStudent(String mentorcollegeid,String mentordepartment,String mentorbatch)
	{
		String query="select name,rollno from student where collegeid='"+mentorcollegeid+"' and department='"+mentordepartment+"' and batch='"+mentorbatch+"' and approval='true'";
		Connection con=DBHelper.openConnection();
		ResultSet res=DBHelper.executeQuery(con, query);
		return res;
		
	}
	public static boolean cancelStudentApproval(String studentrollno)
	{
		String query="delete from student where rollno='"+studentrollno+"'";
		Connection con=DBHelper.openConnection();
		boolean res=DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else
			return false;
	}
	public static boolean acceptStudentApproval(String studentrollno)
	{
		String query="update student set approval='true' where rollno='"+studentrollno+"'";
		Connection con=DBHelper.openConnection();
		boolean res=DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else
			return false;
	}
	public static boolean removeStudentRequests(String studentrollno)
	{
		Connection con=DBHelper.openConnection();
		String query ="delete from mentor_requests where studentrollno='"+studentrollno+"'";
		boolean res =DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else 
			return
					false;
	}
}

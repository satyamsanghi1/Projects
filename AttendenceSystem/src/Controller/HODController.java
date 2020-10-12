package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

import Model.CollegeRegistration;
import Model.HOD;

public class HODController {

	public static boolean addNewRecord(HOD H)
	{
		try
		{
		String query;
		query="insert into hod_registration(enrollmentno,name,department,username,password,email,phoneno,approval,collegeid) values('"+H.getEnrollmentno()+"','"+H.getName()+"','"+H.getDepartment()+"','"+H.getUsername()+"','"+H.getPassword()+"','"+H.getEmail()+"','"+H.getPhoneno()+"','false','"+H.getCollegeid()+"')";
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
	public static boolean addNewHODRequest(String HODEnrollmentno)
	{
		try
		{
	   Connection con= DBHelper.openConnection();
	   String query1="insert into college_requests values('"+HODEnrollmentno+"')";
	  
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
			String query="select * from hod_registration where enrollmentno='"+enrollmentno+"' and password='"+password+"' and approval='true'";
	       ResultSet rs= DBHelper.executeQuery(con, query);
	       return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	// Teacher methods
	// these methods handle the request of teacher 
	
	public static ResultSet showTeacherRequests(String Hodcollegeid,String Hoddepartment)
	{
		try
		{
		Connection con=DBHelper.openConnection();
		String query="select T.name,T.enrollmentno , B.branchname from teacher T,branch B ,hod_requests H where T.collegeid='"+Hodcollegeid+"' and B.branchid='"+Hoddepartment+"' and H.teacherenrollmentno=T.enrollmentno";
		ResultSet rs=DBHelper.executeQuery(con, query);
		return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	public static ResultSet showRegisteredTeacher(String Hodcollegeid,String Hoddepartment)
	{
		String query="select T.name,T.enrollmentno,B.branchname from teacher T,branch B where T.collegeid='"+Hodcollegeid+"' and B.branchid='"+Hoddepartment+"' and approval='true';";
		Connection con=DBHelper.openConnection();
		ResultSet res=DBHelper.executeQuery(con, query);
		return res;
		
	}
	public static boolean cancelTeacherApproval(String TeacherEnrollmentNo)
	{
		String query="delete from teacher where enrollmentno='"+TeacherEnrollmentNo+"'";
		Connection con=DBHelper.openConnection();
		boolean res=DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else
			return false;
	}
	public static boolean acceptTeacherApproval(String TeacherEnrollmentNo)
	{
		String query="update teacher set approval='true' where enrollmentno='"+TeacherEnrollmentNo+"'";
		Connection con=DBHelper.openConnection();
		boolean res=DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else
			return false;
	}
	public static boolean removeTeacherRequests(String TeacherEnrollmentNo)
	{
		Connection con=DBHelper.openConnection();
		String query ="delete from hod_requests where teacherenrollmentno='"+TeacherEnrollmentNo+"'";
		boolean res =DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else 
			return
					false;
	}
	
	// Mentor Methods
	
	public static ResultSet showMentorRequests(String Hodcollegeid,String Hoddepartment)
	{
		try
		{
			String query="select distinct M.* from batch_section_semester B, mentor M,hod_requests H where H.mentorenrollmentno=M.enrollmentno and M.collegeid='"+Hodcollegeid+"' and M.department='"+Hoddepartment+"'";
		Connection con=DBHelper.openConnection();
		ResultSet rs=DBHelper.executeQuery(con, query);
		return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	//giving error
	public static ResultSet showRegisteredMentor(String Hodcollegeid,String Hoddepartment)
	{
		String query="select M.* , B.branchname from mentor M,branch B where approval='true' and collegeid='"+Hodcollegeid+"' and department='"+Hoddepartment+"' and M.department=B.branchid";
		Connection con=DBHelper.openConnection();
		ResultSet res=DBHelper.executeQuery(con, query);
		return res;
		
	}
	public static boolean cancelMentorApproval(String MentorEnrollmentNo)
	{
		String query="delete from mentor where enrollmentno='"+MentorEnrollmentNo+"'";
		Connection con=DBHelper.openConnection();
		boolean res=DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else
			return false;
	}
	public static boolean acceptMentorApproval(String MentorEnrollmentNo)
	{
		String query="update mentor set approval='true' where enrollmentno='"+MentorEnrollmentNo+"'";
		Connection con=DBHelper.openConnection();
		boolean res=DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else
			return false;
	}
	public static boolean removeMentorRequests(String MentorEnrollmentNo)
	{
		Connection con=DBHelper.openConnection();
		String query ="delete from hod_requests where mentorenrollmentno='"+MentorEnrollmentNo+"'";
		boolean res =DBHelper.executeUpdate(con, query);
		if(res)
			return true;
		else 
			return
					false;
	}
}

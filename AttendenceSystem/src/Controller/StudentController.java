package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

import Model.HOD;
import Model.Student;

public class StudentController {

	public static boolean addNewRecord(Student S)
	{
		try
		{
		String query;
		query="insert into student (rollno,name,batch,department,semester,email,password,phoneno,section,collegeid,approval) values ('"+S.getRollno()+"','"+S.getName()+"','"+S.getBatch()+"','"+S.getDepartment()+"','"+S.getSemester()+"','"+S.getEmail()+"','"+S.getPassword()+"','"+S.getPhoneno()+"','"+S.getSection()+"','"+S.getCollegeid()+"','false')";
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
	public static boolean addNewStudentRequest(String StudentRollno)
	{
		try
		{
	   Connection con= DBHelper.openConnection();
	   String query1="insert into mentor_requests (studentrollno) values('"+StudentRollno+"')";
	  
	 boolean res= DBHelper.executeUpdate(con, query1);
	  return res;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public static ResultSet loginCheck(String rollno,String password)
	{
		try {
			Connection con=DBHelper.openConnection();
			String query="select * from student where rollno='"+rollno+"' and password='"+password+"' and approval='true'";
	       ResultSet rs= DBHelper.executeQuery(con, query);
	       return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	//for teacher homepage
	public static ResultSet showStudentAttendance(String collegeid,String teacherenrollmentno,String studentrollno,String date)
	{
		try
		{
			Connection con=DBHelper.openConnection();
		String query="select * from attendance where collegeid='"+collegeid+"' and teacherenrollmentno='"+teacherenrollmentno+"' and studentrollno='"+studentrollno+"' and date='"+date+"'";
		ResultSet rs=DBHelper.executeQuery(con, query);
		return rs;
		
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	//for student homepage
	public static ResultSet showStudentAttendance1(String studentrollno)
	{
		try
		{
			Connection con=DBHelper.openConnection();
		String query="select A.attendance,A.date,T.name,T.subject from attendance A,teacher T  where A.studentrollno='"+studentrollno+"' and A.teacherenrollmentno=T.enrollmentno";
		ResultSet rs=DBHelper.executeQuery(con, query);
		return rs;
		
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
}

	
	


package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

import Model.Teacher;

public class TeacherController {
 
	public static boolean addNewRecord(Teacher T)
	{
		Connection cn=DBHelper.openConnection();
		String query="insert into teacher(enrollmentno,name,department,subject,collegeid,password,email,approval) values('"+T.getEnrollmentno()+"','"+T.getName()+"','"+T.getDepartment()+"','"+T.getSubject()+"','"+T.getCollegeid()+"','"+T.getPassword()+"','"+T.getEmail()+"','false')";
boolean rs=DBHelper.executeUpdate(cn, query);

          if(rs)
	    return true;
     
          else  
        	  return false;
	}

public static boolean addNewTeacherRequest(String teacherenrollmentno)
{
	Connection cn=DBHelper.openConnection();
String query1="insert into hod_requests(teacherenrollmentno,mentorenrollmentno) values('"+teacherenrollmentno+"','null')";
boolean res=DBHelper.executeUpdate(cn, query1);
if( res)
return true;
 
else return false;
}

public static ResultSet loginCheck(String enrollmentno,String password)
{
	try {
		Connection con=DBHelper.openConnection();
		String query="select * from teacher where enrollmentno='"+enrollmentno+"' and password='"+password+"' and approval='true'";
       ResultSet rs= DBHelper.executeQuery(con, query);
       return rs;
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
}
public static boolean assignAttendance(String studentrollno,String teacherenrollmentno,String Attendance,String collegeid,String date)
{
	try
	{
		Connection con=DBHelper.openConnection();
		String query="insert into attendance (studentrollno,teacherenrollmentno,attendance,collegeid,date) values('"+studentrollno+"','"+teacherenrollmentno+"','"+Attendance+"','"+collegeid+"','"+date+"')";
		boolean rs=DBHelper.executeUpdate(con, query);
		return rs;
	}
	catch(Exception e)
	{
		
		System.out.println(e);
		return false;
	}
}
public static ResultSet showStudentForAttendance(String collegeid,String department,String batch,String semester,String section)
{
	try
	{
		Connection con=DBHelper.openConnection();
	String query="select * from student where collegeid='"+collegeid+"' and department='"+department+"' and batch='"+batch+"' and semester='"+semester+"' and section='"+section+"'";
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
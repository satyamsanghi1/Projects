package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

public class DBHelper {
public static Connection openConnection()
{
try
{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence_system","root","123");
	return con;
}
catch(Exception e)
{
	System.out.println("[DBHelper:openConnection] "+e);
	return null;
}
}
public static boolean executeUpdate(Connection con,String query)
{
	try
	{
		Statement smt=con.createStatement();
		smt.executeUpdate(query);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("[DBHelper:executeUpdate] "+e);
		return false;
	}
}
public static ResultSet executeQuery(Connection con,String query)
{
	try
	{
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(query);
		return rs ;
	}
	catch(Exception e)
	{
		System.out.println("[DBHelper:executequery] "+e);
		return null;
	}
}
public static ArrayList<JSONObject> JSONEngine(ResultSet rs)
{
/*	ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
	try {
	//get column names
	/*ResultSetMetaData rsMeta = rs.getMetaData();
	int columnCnt = rsMeta.getColumnCount();
	ArrayList<String> columnNames = new ArrayList<String>();
	for(int i=1;i<=columnCnt;i++) {
	columnNames.add(rsMeta.getColumnName(i).toUpperCase());
	}

	while(rs.next()) { // convert each object to an human readable JSON object
	JSONObject obj = new JSONObject();
	for(int i=1;i<=columnCnt;i++) {
	String key = columnNames.get(i - 1);
	String value = rs.getString(i);
	obj.put(key, value);
	}
	resList.add(obj);
	}
	} catch(Exception e) {
	e.printStackTrace();
	} finally {
	try {
	rs.close();
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	return resList;*/
	
	 try {
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
   	return obj;
	}
	 catch (Exception e) {
		System.out.print(e);
		return null;
	}
}
}

   
	


package Controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class CountryStateCityController {
public static ResultSet getAllCountry()
{
	Connection Con=DBHelper.openConnection();
	String query="select * from country";
	      ResultSet rs=DBHelper.executeQuery(Con, query);
	      return rs;
}
}

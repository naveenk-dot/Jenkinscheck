package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

	
	public void ConnectSQL() throws SQLException
	{
		
		String JDBCURL="";
		
		Connection connection= DriverManager.getConnection(JDBCURL);
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("Query");
		
		while(resultset.next())
		{
			System.out.println(resultset.getInt(0)+" "+resultset.getString(0));
		}
	}
}

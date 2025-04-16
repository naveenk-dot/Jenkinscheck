package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class SQLConnection {

	
	@Test
	public Object[][] ConnectSQL() throws SQLException
	{
		
		String JDBCURL="jdbc:mysql://localhost:3306/qadbt";	
		Connection connection= DriverManager.getConnection(JDBCURL,"root","Naveen@08375");
		Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
		ResultSet.CONCUR_READ_ONLY);
		ResultSet resultset=statement.executeQuery("Select * from students");
		resultset.last();
		int rowCount=resultset.getRow();
		resultset.beforeFirst();
		int columnCount=resultset.getMetaData().getColumnCount();
		Object[][] data=new Object[rowCount][columnCount];
		List<Object> dataset=new ArrayList<>();
		int rowindex=0;
		while(resultset.next())
			 
		{
			for (int j=0;j<columnCount;j++)
			{
				
				data[rowindex][j]=resultset.getObject(j+1);
			}
			rowindex++;
		}
		return data;
		
	}
}

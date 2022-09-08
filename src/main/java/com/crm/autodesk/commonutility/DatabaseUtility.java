package com.crm.autodesk.commonutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all the methods related to database connection and data fetching from it.
 * @author Soumyajit
 *
 */
public class DatabaseUtility {
	Connection connect;
	
	/**
	 * This method will connect Java to database.
	 */
	public void connectToDatabase()
	{
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connect = DriverManager.getConnection(IPathConstants.MYSQL_URL,IPathConstants.MYSQL_USERNAME,IPathConstants.MYSQL_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will close the connection between java and database.
	 */
	public void closeConToDatabase()
	{
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will fetch the data from the database based on the query.
	 * @param query
	 * @return
	 */
	public ResultSet fetchDataFromDatabase(String query)
	{
		ResultSet result=null;
		try {
			 result=connect.createStatement().executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insertDataIntoDatabase(String query)
	{
		boolean flag = false;
		try {
			
			int result = connect.createStatement().executeUpdate(query);
			
			if(result==1)
			{
				System.out.println("Data inserted successfully");
				flag = true;
				return flag;
			}
			else
			{
				System.out.println("Data can't be inserted");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	

}

package com.practiceMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_Mysql_Query_Update {
	

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		 int result  = 0;
		
		try
		{
			Driver driver = new Driver();
			//step-1: load my SQL database
			DriverManager.registerDriver(driver);
			
			//step-2: connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root" , "root");
			System.out.println("connection is done");
			
			//step-3: create query statement
			Statement s = con.createStatement();
			String query = "insert into students_info values ('6', 'chiku', 's', 'mandal')";
			
			//step-4: execute query
	     	result = s.executeUpdate(query);
	     	
			
		}
		catch(Exception e)
		{
			System.out.println("exception handled");
		}
		
		finally
		{
			if(result == 1)
			{
				System.out.println("data inserted successfully");
			}
			else
			{
				System.err.println("data can't be inserted");
			}
			
			//step-5: close the database connection
			con.close();
			System.out.println(".....db connection closed.....");
		}

	}

}

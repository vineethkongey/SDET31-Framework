package com.practiceMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class Sample_Mysql_Query_Execution {
	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		try
	{
		Driver driver = new Driver();
		
		//step-1:load my SQL database
		DriverManager.registerDriver(driver);
		
		//step-2:connect to database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		System.out.println("connection is done");
		
		//step-3:create query statement
		Statement s = con.createStatement();
		String query = "select * from students_info";
		
		//step-4: execute query
		ResultSet result = s.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
			
		}
	}
		catch(Exception e)
	 {
		System.out.println("nothing");	
	 }
		
		finally
		{
			//step-5: close the connection
			con.close();
			System.out.println(".......db connection closed......");
		}
		
	}

}

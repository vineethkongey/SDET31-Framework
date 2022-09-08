package com.practiceMaven;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.crm.autodesk.commonutility.DatabaseUtility;

public class DataBaseUtilityPractice {
	DatabaseUtility db = new DatabaseUtility();
	
	@Test
	public void fetchData()
	{
		
		
		db.connectToDatabase();
		ResultSet result = db.fetchDataFromDatabase("Select * from students_info");
		try {
			while(result.next())
			{
				System.out.println(result.getString(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t" + result.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.closeConToDatabase();
	}
	
	@Test
	public void insertData()
	{
		db.connectToDatabase();
		boolean flag = db.insertDataIntoDatabase("insert into students_info values('8' , 'Jagu' , 'mandal' , 'k')");
		 System.out.println(flag);
	
		db.closeConToDatabase();
		
		
	}

}

package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	// Getting connected to database
	Connection con=null;
	public void getDataBaseConnection(String url, String username, String passowrd) throws SQLException
	{
		try {
				
			Driver dr = new Driver();
			DriverManager.registerDriver(dr);
			con = DriverManager.getConnection(url, username, passowrd);
			}
		catch (Exception e) 
		{
			System.out.println("Exception occured while Connecting to Database");		
		}
	}
	
	// Getting connected to database with default database
		public void getDataBaseConnection() throws SQLException
		{
			try {
					
				Driver dr = new Driver();
				DriverManager.registerDriver(dr);
				con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
				}
			catch (Exception e) 
			{
				System.out.println("Exception occured while Connecting to Database");		
			}
		}
	//Closing connection
	public void closeDbConnection() throws SQLException
	{
		try {
			con.close();
			}
		catch (Exception e) 
		{
			System.out.println("Connection not closed");
		}
	
	}
	// Execute select query 
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet resultSet=null;
		try {
			Statement st = con.createStatement();
			resultSet = st.executeQuery(query);
			}
		catch (Exception e) 
		{
			System.out.println("Exception Occured while Executing Query");
		}
		return resultSet;
	}
	//Execute non select query
	
	public int executeNonSelectQuery(String query) throws SQLException
	{
		int result=0;
		try 
		{
			Statement st = con.createStatement();
			result = st.executeUpdate(query);
		}
		catch (Exception e) 
		{
			System.out.println("Exception occured while executing nonselect query");
		}
		return result;
	}
}

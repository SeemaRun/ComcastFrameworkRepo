package com.comcast.crm.genericdatabaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	//method1
  public void getDBConnection(String url,String username,String password) throws SQLException
  {
	  try {
	  
	 Driver driver = new Driver();
	  DriverManager.registerDriver(driver);
	  
	  con = DriverManager.getConnection(url,username,password);
  } catch(Exception e) 
	  {
	  } 
  }
  //method2
  public void getDBConnection() throws SQLException
  {
	  try {
	  Driver driver = new Driver();
	  DriverManager.registerDriver(driver);
	  
	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
  } catch(Exception e) 
	  {
	  } 
  }
  //method3
	  public void closeDBConnection() throws SQLException
	  {
		con.close();  
	  }
	  public ResultSet  executeConSelectQuery(String query) throws SQLException
	  {
		  ResultSet result = null;
		  try {
		  Statement stat = con.createStatement();
	 result	 = stat.executeQuery(query);
	  }catch (Exception e) {
	  }
		  return result;
	  }
	  
	  //method4
	  public int executeNoneselectQuery(String query) {
		  int result = 0;
	  
		  try {
		  Statement stat = con.createStatement();
		  result   = stat.executeUpdate(query);
	  }catch (Exception e)
	  {
	  }
		  return result;
	  }
}

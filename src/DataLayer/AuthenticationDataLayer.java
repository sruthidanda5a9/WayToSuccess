package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import DTO.AuthenticationDTO;
import Model.AuthenticationModel;
import Repository.AuthenticationInterface;

public class AuthenticationDataLayer implements AuthenticationInterface{
	
	public AuthenticationModel getUsers(String id) {
		ResultSet myRes = null;
		AuthenticationModel authenticationModel = new AuthenticationModel();
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//1. get connection to the database
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			//2.create a statement
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT * from Authentication where userName='"+id+"'");
			//4. process the result set
			while(myRes.next())
			{
			System.out.println(myRes.getString("userName"));
			authenticationModel.setUserName(myRes.getString("userName"));
			authenticationModel.setPassword(myRes.getString("passWord"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return authenticationModel;
	}
	@Override
	public ResultSet getAllUsers() {
		// TODO Auto-generated method stub
		ResultSet myRes = null;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
					Statement myStmt = myCon.createStatement();
					myRes  = myStmt.executeQuery("SELECT * from Authentication ");
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return myRes;
	}
	@Override
	public void insert(AuthenticationModel authenticationModel) {
		try
		{
			String username = authenticationModel.getUserName();
			String passWord= authenticationModel.getPassword();
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("INSERT INTO Authentication (`userName`, `password`) VALUES ('"+username+"', '"+passWord+"')");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void resetPassword(AuthenticationModel authenticationModel) {
		// TODO Auto-generated method stub
		/*
		 * To rest your password.
		 */
		try
		{
			String username = authenticationModel.getUserName();
			String passWord= authenticationModel.getPassword();
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("update  Authentication set  `password` = '"+passWord+"' where `userName`='"+username +"';");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}}

